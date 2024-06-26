package org.example.domain.services

import openBook.model.Author
import org.example.adapter.CoreSearchAdapter
import org.example.domain.model.exceptions.AuthorNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorSearchService(
    private val coreSearchAdapter: CoreSearchAdapter
) {
    suspend fun getAuthorById(authorId: UUID): Author {
        return coreSearchAdapter.getAuthorById(authorId)
            ?: throw AuthorNotFoundException("Author with id: $authorId not found")
    }
}