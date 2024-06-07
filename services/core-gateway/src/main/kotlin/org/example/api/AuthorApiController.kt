package org.example.api

import openBook.api.AuthorApi
import openBook.model.Author
import org.example.CoreCatalogAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class AuthorApiController(
    private val coreCatalogAdapter: CoreCatalogAdapter
) : AuthorApi {
    override suspend fun v1AuthorDetailsAuthorIdGet(authorId: UUID): ResponseEntity<Author> =
        ResponseEntity.ok().body(coreCatalogAdapter.getAuthorDetails(authorId))
}