package org.example.adapters.`in`.rest

import openBook.api.AuthorApi
import openBook.model.Author
import org.example.ports.`in`.AuthorSearchUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class AuthorSearchController(
    private val authorService: AuthorSearchUseCase,
) : AuthorApi {
    override suspend fun v1AuthorDetailsAuthorIdGet(authorId: UUID): ResponseEntity<Author> {
        return ResponseEntity.ok().body(authorService.getAuthorDetails(authorId))
    }
}