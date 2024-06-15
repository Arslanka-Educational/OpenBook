package org.example.api

import openBook.api.BookingApi
import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReservationId
import openBook.model.BookReserveResponse
import org.example.adapter.CoreBookingAdapter
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookingApiController(
    private val coreBookingAdapter: CoreBookingAdapter
) : BookingApi {
    override suspend fun v1ReservationBookIdGet(bookId: UUID): ResponseEntity<BookReservationDetailsResponse> =
        ResponseEntity.ok().body(coreBookingAdapter.v1GetReservation(bookId))

    override suspend fun v1ReservePost(bookReservationId: BookReservationId): ResponseEntity<BookReserveResponse> =
        ResponseEntity.ok().body(coreBookingAdapter.v1ReserveBook(bookReservationId.bookId))
}