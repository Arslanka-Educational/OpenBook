package org.example.ports.out

import openBook.model.Author
import java.util.UUID

interface AuthorRepository {
    suspend fun findById(authorId: UUID): Author?
}