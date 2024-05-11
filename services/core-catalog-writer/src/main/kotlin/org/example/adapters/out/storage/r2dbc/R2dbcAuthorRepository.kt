package org.example.adapters.out.storage.r2dbc

import openBook.model.Author
import org.example.ports.out.storage.AuthorCreationRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitOne
import org.springframework.r2dbc.core.awaitSingleOrNull
import org.springframework.stereotype.Repository

@Repository
class R2dbcAuthorRepository(
    private val databaseClient: DatabaseClient
) : AuthorCreationRepository {
    override suspend fun createAuthor(author: Author) {
        databaseClient.sql(INSERT_AUTHOR)
            .bind("id", author.id)
            .bind("name", author.name)
            .fetch()
            .awaitSingleOrNull()
    }

    private companion object {
        private val INSERT_AUTHOR = """
            INSERT INTO author(id, name) VALUES(:id, :name)
        """.trimIndent()
    }
}