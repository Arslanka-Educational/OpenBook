package org.example.adapters.`in`.rest

import openBook.api.BookApi
import openBook.model.BookGetByInfoIdResponse
import openBook.model.BookGetByNameResponse
import org.example.ports.`in`.BookSearchUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookSearchController(
    private val bookService: BookSearchUseCase
) : BookApi {
    override suspend fun v1BookGetByInfoBookInfoIdGet(bookInfoId: UUID): ResponseEntity<BookGetByInfoIdResponse> {
        val booksList = bookService.getBooksByInfoId(bookInfoId)
        return ResponseEntity.ok().body(
            BookGetByInfoIdResponse(
                bookInfoId = bookInfoId,
                books = booksList
            )
        )
    }

    override suspend fun v1BookFindByNameBookNameGet(bookName: String): ResponseEntity<BookGetByNameResponse> {
        val bookInfoList = bookService.findBookInfoByName(bookName)
        return ResponseEntity.ok().body(
            BookGetByNameResponse(
                booksInfo = bookInfoList
            )
        )
    }
}