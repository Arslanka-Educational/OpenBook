package org.example.adapters.out.storage.r2dbc

import openBook.model.Library
import org.example.ports.out.storage.LibraryCreationRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitOneOrNull
import org.springframework.stereotype.Repository

@Repository
class R2dbcLibraryRepository(
    private val databaseClient: DatabaseClient
): LibraryCreationRepository {
    override suspend fun createLibrary(library: Library) {
        databaseClient.sql(INSERT_LIBRARY)
            .bind("id", library.id)
            .bind("name", library.name)
            .bind("city", library.city)
            .fetch()
            .awaitOneOrNull()
    }

    private companion object {
        private val INSERT_LIBRARY = """
            INSERT INTO library(id, name, city) VALUES (:id, :name, :city)
        """.trimIndent()
    }
}