package openbook.controller

import openBook.api.BookApi
import openBook.model.BookCreateRequest
import openBook.model.BookDetailsResponse
import org.springframework.http.ResponseEntity

class BookController : BookApi {
    override fun v1BookCreatePost(bookCreateRequest: BookCreateRequest): ResponseEntity<BookDetailsResponse> {
        TODO("Not yet implemented")
    }

    override fun v1BookDetailsBookIdGet(bookId: String): ResponseEntity<BookDetailsResponse> {
        TODO("Not yet implemented")
    }
}