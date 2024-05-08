package org.example.domain.services

import openBook.model.AuthorDetailsResponse
import org.example.domain.model.exceptions.AuthorNotFoundException
import org.example.ports.`in`.AuthorSearchUseCase
import org.example.ports.out.AuthorRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorSearchService(
    private val authorRepository: AuthorRepository
) : AuthorSearchUseCase {
    override suspend fun getAuthorDetails(authorId: UUID): AuthorDetailsResponse {
        val author =
            authorRepository.findById(authorId) ?: throw AuthorNotFoundException("Author with $authorId not found")

        return AuthorDetailsResponse(
            id = author.id,
            name = author.name
        )
    }
}