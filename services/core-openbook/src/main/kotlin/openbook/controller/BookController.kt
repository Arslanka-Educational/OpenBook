package openbook.controller

import openBook.api.BookApi
import openBook.model.*
import openbook.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class BookController(
    val service: BookService
) : BookApi {

    override fun v1BookFindByNameBookNameGet(bookName: String): ResponseEntity<List<BookInfo>> {
        return ResponseEntity.ok().body(
            service.getBookInfoListByName(bookName = bookName)
        )
    }

    override fun v1BookGetByInfoBookInfoIdGet(bookInfoId: UUID): ResponseEntity<BookGetByInfoIdResponse> {
        return ResponseEntity.ok().body(
            service.getBooksByInfoId(bookInfoId)
        )
    }

    override fun v1BookReservationPost(v1BookReservationPostRequest: V1BookReservationPostRequest): ResponseEntity<BookReserveResponse> {
        return ResponseEntity.ok().body(
            service.reserveBook(v1BookReservationPostRequest.bookId)
        )
    }
}