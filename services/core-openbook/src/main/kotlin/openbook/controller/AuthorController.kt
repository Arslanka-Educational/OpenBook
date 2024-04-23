package openbook.controller

import openBook.api.AuthorApi
import openBook.model.AuthorCreateRequest
import openBook.model.AuthorDetailsResponse
import org.springframework.http.ResponseEntity

class AuthorController : AuthorApi {
    override fun v1AuthorCreatePost(authorCreateRequest: AuthorCreateRequest): ResponseEntity<AuthorDetailsResponse> {
        TODO("Not yet implemented")
    }

    override fun v1AuthorDetailsAuthorIdGet(authorId: String): ResponseEntity<AuthorDetailsResponse> {
        TODO("Not yet implemented")
    }
}