package org.example.ports.out.storage

import openBook.model.Author

interface AuthorCreationRepository {
    suspend fun createAuthor(author: Author)
}