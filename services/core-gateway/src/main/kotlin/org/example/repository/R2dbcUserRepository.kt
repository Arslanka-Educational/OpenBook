package org.example.repository

import kotlinx.coroutines.reactor.awaitSingleOrNull
import org.example.domain.User
import org.example.repository.util.UserTypeUtil
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitRowsUpdated
import org.springframework.r2dbc.core.awaitSingleOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class R2dbcUserRepository(
    private val databaseClient: DatabaseClient
) {
    suspend fun getByUsername(username: String): User? =
        databaseClient.sql(GET_BY_USERNAME)
            .bind("username", username)
            .map { r, _ ->
                User(
                    id = r.get("id") as UUID,
                    name = r.get("name") as String,
                    password = r.get("password") as String,
                    email = r.get("email") as String,
                    userType = UserTypeUtil.fromValue(r.get("user_type") as String)
                )
            }
            .first()
            .awaitSingleOrNull()

    suspend fun registerUser(user: User) =
        databaseClient.sql(INSERT_USER)
            .bind("id", user.id)
            .bind("username", user.name)
            .bind("password", user.password)
            .bind("email", user.email)
            .bind("user_type", user.userType.typeName)
            .fetch()
            .rowsUpdated()
            .thenReturn(user)
            .awaitSingleOrNull()

    private companion object {
        val GET_BY_USERNAME = """
            SELECT id, name, password, email, user_type FROM users WHERE name LIKE CONCAT('%', :username, '%')
        """.trimIndent()

        val INSERT_USER = """
            INSERT INTO users(id, name, password, email, user_type) VALUES (:id, :username, :password, :email, :user_type)
        """.trimIndent()
    }
}