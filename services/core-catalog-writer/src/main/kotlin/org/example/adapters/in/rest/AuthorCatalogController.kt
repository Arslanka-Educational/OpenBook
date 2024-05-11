package org.example.adapters.`in`.rest

import openBook.api.AuthorCatalogApi
import openBook.model.Author
import openBook.model.AuthorCreateDetails
import org.example.ports.`in`.useCases.AuthorCreationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorCatalogController(
    private val authorCreationUseCase: AuthorCreationUseCase
) : AuthorCatalogApi {
    override suspend fun v1AuthorCreatePost(authorCreateDetails: AuthorCreateDetails): ResponseEntity<Author> {
        val author = authorCreationUseCase.createAuthor(authorCreateDetails)
        return ResponseEntity.ok().body(author)
    }
}