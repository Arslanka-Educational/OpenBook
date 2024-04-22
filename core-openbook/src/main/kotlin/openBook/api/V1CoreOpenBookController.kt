package openBook.api

import openBook.model.AuthorCreateRequest
import openBook.model.AuthorDetailsResponse
import openBook.model.BookCreateRequest
import openBook.model.BookDetailsResponse
import openBook.model.LibraryCreateRequest
import openBook.model.LibraryDetailsResponse
import openBook.model.NotFoundResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired


import kotlin.collections.List
import kotlin.collections.Map

@RestController
@RequestMapping("\${api.base-path:}")
class V1CoreOpenBookController(@Autowired(required = true) val service: V1CoreOpenBookService) {


    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/v1/author/create"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun v1AuthorCreatePost( @RequestBody authorCreateRequest: AuthorCreateRequest): ResponseEntity<AuthorDetailsResponse> {
        return ResponseEntity(service.v1AuthorCreatePost(authorCreateRequest), HttpStatus.valueOf(200))
    }


    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/v1/author/details/{author_id}"],
        produces = ["application/json"]
    )
    fun v1AuthorDetailsAuthorIdGet( @PathVariable("author_id") authorId: kotlin.String): ResponseEntity<AuthorDetailsResponse> {
        return ResponseEntity(service.v1AuthorDetailsAuthorIdGet(authorId), HttpStatus.valueOf(200))
    }


    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/v1/book/create"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun v1BookCreatePost( @RequestBody bookCreateRequest: BookCreateRequest): ResponseEntity<BookDetailsResponse> {
        return ResponseEntity(service.v1BookCreatePost(bookCreateRequest), HttpStatus.valueOf(200))
    }


    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/v1/book/details/{book_id}"],
        produces = ["application/json"]
    )
    fun v1BookDetailsBookIdGet( @PathVariable("book_id") bookId: kotlin.String): ResponseEntity<BookDetailsResponse> {
        return ResponseEntity(service.v1BookDetailsBookIdGet(bookId), HttpStatus.valueOf(200))
    }


    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/v1/library/create"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun v1LibraryCreatePost( @RequestBody libraryCreateRequest: LibraryCreateRequest): ResponseEntity<LibraryDetailsResponse> {
        return ResponseEntity(service.v1LibraryCreatePost(libraryCreateRequest), HttpStatus.valueOf(200))
    }


    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/v1/library/details/{library_id}"],
        produces = ["application/json"]
    )
    fun v1LibraryDetailsLibraryIdGet( @PathVariable("library_id") libraryId: kotlin.String): ResponseEntity<LibraryDetailsResponse> {
        return ResponseEntity(service.v1LibraryDetailsLibraryIdGet(libraryId), HttpStatus.valueOf(200))
    }
}
