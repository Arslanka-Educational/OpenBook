package org.example.ports.`in`

import openBook.model.Author
import java.util.UUID

interface AuthorSearchUseCase {
    suspend fun getAuthorDetails(authorId: UUID): Author?
}