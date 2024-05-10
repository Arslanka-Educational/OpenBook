package org.example.adapters.`in`.rest

import openBook.api.BookApi
import openBook.model.BookGetByInfoIdResponse
import openBook.model.BookGetByNameResponse
import openBook.model.BookInfo
import org.example.domain.services.BookSearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookSearchController(
    private val bookService: BookSearchService
) : BookApi {
    override suspend fun v1BookGetByInfoBookInfoIdGet(bookInfoId: UUID): ResponseEntity<BookGetByInfoIdResponse> {
        val booksList = bookService.getBooksByInfoId(bookInfoId)
        return ResponseEntity.ok().body(
            BookGetByInfoIdResponse(
                bookInfoId = bookInfoId,
                books = booksList,
            )
        )
    }

    override suspend fun v1BookInfoDetailsBookInfoIdGet(bookInfoId: UUID): ResponseEntity<BookInfo> {
        val bookInfo = bookService.getBookInfoDetails(bookInfoId)
        return ResponseEntity.ok().body(bookInfo)
    }

    override suspend fun v1BookGetByNameBookNameGet(bookName: String): ResponseEntity<BookGetByNameResponse> {
        val bookInfoList = bookService.getBookInfoByName(bookName)
        return ResponseEntity.ok().body(
            BookGetByNameResponse(
                booksInfo = bookInfoList
            )
        )
    }
}