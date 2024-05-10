package org.example.domain.services

import openBook.model.Author
import org.example.ports.`in`.AuthorSearchUseCase
import org.example.ports.out.AuthorRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorSearchService(
    private val authorRepository: AuthorRepository
) : AuthorSearchUseCase {
    override suspend fun getAuthorDetails(authorId: UUID): Author? =
        authorRepository.findById(authorId)
}