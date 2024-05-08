package org.example.ports.`in`

import openBook.model.AuthorDetailsResponse
import java.util.UUID

interface AuthorSearchUseCase {
    suspend fun getAuthorDetails(authorId: UUID): AuthorDetailsResponse
}