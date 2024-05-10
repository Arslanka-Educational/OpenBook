package org.example.adapters.`in`.rest

import openBook.api.AuthorApi
import openBook.model.Author
import org.example.domain.services.AuthorSearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class AuthorSearchController(
    private val authorService: AuthorSearchService,
) : AuthorApi {
    override suspend fun v1AuthorDetailsAuthorIdGet(authorId: UUID): ResponseEntity<Author> {
        return ResponseEntity.ok().body(authorService.getAuthorById(authorId))
    }
}