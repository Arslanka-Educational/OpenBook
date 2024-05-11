package org.example.domain.services

import openBook.model.Author
import openBook.model.AuthorCreateDetails
import org.example.ports.`in`.useCases.AuthorCreationUseCase
import org.example.ports.out.storage.AuthorCreationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorCreationService(
    private val authorCreationRepository: AuthorCreationRepository
) : AuthorCreationUseCase {
    override suspend fun createAuthor(authorDetails: AuthorCreateDetails): Author {
        val author = Author(
            id = UUID.randomUUID(),
            name = authorDetails.name
        )
        authorCreationRepository.createAuthor(author)
        return author
    }
}