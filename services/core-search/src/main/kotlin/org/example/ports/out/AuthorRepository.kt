package org.example.ports.out

import org.example.domain.model.Author
import java.util.UUID

interface AuthorRepository {
    suspend fun findById(authorId: UUID): Author?
}