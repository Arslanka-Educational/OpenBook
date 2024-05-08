package org.example.adapters.out.r2dbc

import openBook.model.Author
import org.example.ports.out.AuthorRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitOneOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class R2dbcAuthorRepository(
    private val databaseClient: DatabaseClient
) : AuthorRepository {
    override suspend fun findById(authorId: UUID): Author? = databaseClient
        .sql(GET_BY_ID)
        .bind("id", authorId)
        .map { r, _ ->
            Author(
                id = r.get("id") as UUID,
                name = r.get("name") as String
            )
        }.awaitOneOrNull()

    private companion object {
        private val GET_BY_ID = """
            SELECT id, name FROM author WHERE id = :id
        """.trimIndent()
    }
}