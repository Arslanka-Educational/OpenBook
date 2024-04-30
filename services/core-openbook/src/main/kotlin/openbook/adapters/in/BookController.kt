package openbook.adapters.`in`

import openBook.api.BookApi
import openBook.model.BookGetByInfoIdResponse
import openBook.model.BookInfo
import openBook.model.BookReserveResponse
import openBook.model.V1BookReservationPostRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookController : BookApi {
    override fun v1BookFindByNameBookNameGet(bookName: String): ResponseEntity<List<BookInfo>> {
        TODO("Not yet implemented")
    }

    override fun v1BookGetByInfoBookInfoIdGet(bookInfoId: UUID): ResponseEntity<BookGetByInfoIdResponse> {
        TODO("Not yet implemented")
    }

    override fun v1BookReservationPost(v1BookReservationPostRequest: V1BookReservationPostRequest): ResponseEntity<BookReserveResponse> {
        TODO("Not yet implemented")
    }
}