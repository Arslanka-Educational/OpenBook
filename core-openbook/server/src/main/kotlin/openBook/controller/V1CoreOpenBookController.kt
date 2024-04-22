package openBook.controller

import openBook.api.V1CoreOpenBookApi
import openBook.model.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class V1CoreOpenBookController : V1CoreOpenBookApi {
    override fun v1AuthorCreatePost(authorCreateRequest: AuthorCreateRequest): ResponseEntity<AuthorDetailsResponse> {
        TODO("Not yet implemented")
    }

    override fun v1AuthorDetailsAuthorIdGet(authorId: String): ResponseEntity<AuthorDetailsResponse> {
        TODO("Not yet implemented")
    }

    override fun v1BookCreatePost(bookCreateRequest: BookCreateRequest): ResponseEntity<BookDetailsResponse> {
        TODO("Not yet implemented")
    }

    override fun v1BookDetailsBookIdGet(bookId: String): ResponseEntity<BookDetailsResponse> {
        TODO("Not yet implemented")
    }

    override fun v1LibraryCreatePost(libraryCreateRequest: LibraryCreateRequest): ResponseEntity<LibraryDetailsResponse> {
        TODO("Not yet implemented")
    }

    override fun v1LibraryDetailsLibraryIdGet(libraryId: String): ResponseEntity<LibraryDetailsResponse> {
        TODO("Not yet implemented")
    }
}