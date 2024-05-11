package org.example.ports.`in`.useCases

import openBook.model.Author
import openBook.model.AuthorCreateDetails

interface AuthorCreationUseCase {
    suspend fun createAuthor(authorDetails: AuthorCreateDetails) : Author
}