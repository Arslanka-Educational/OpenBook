package org.example.adapters.out.r2dbc

import org.example.domain.model.Library
import org.example.ports.out.LibraryRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitOneOrNull
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class R2dbcLibraryRepository(
    private val databaseClient: DatabaseClient
) : LibraryRepository {
    override suspend fun findById(libraryId: UUID): Library? = databaseClient
        .sql(GET_BY_ID)
        .bind("id", libraryId)
        .map { r, _ ->
            Library(
                id = r.get("id") as UUID,
                name = r.get("name") as String,
                city = r.get("city") as String
            )
        }.awaitOneOrNull()

    private companion object {
        private val GET_BY_ID = """
            SELECT id, name, city FROM library WHERE id = :id
            """.trimIndent()
    }
}