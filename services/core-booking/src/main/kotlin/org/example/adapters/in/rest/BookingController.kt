package org.example.adapters.`in`.rest

import openBook.api.BookingApi
import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReservationId
import openBook.model.BookReserveResponse
import org.example.ports.`in`.BookReservationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookingController(
    private val reservationService: BookReservationUseCase
) : BookingApi {
    override suspend fun v1ReservationBookIdGet(bookId: UUID): ResponseEntity<BookReservationDetailsResponse> {
        val reservationDetails = reservationService.getReservationDetails(bookId)
        return ResponseEntity.ok().body(reservationDetails)
    }

    override suspend fun v1ReservePost(bookReservationId: BookReservationId): ResponseEntity<BookReserveResponse> {
        val reservation = reservationService.reserveBook(bookReservationId.bookId)
        return ResponseEntity.ok().body(reservation)
    }
}