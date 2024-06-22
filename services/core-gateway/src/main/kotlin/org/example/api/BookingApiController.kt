package org.example.api

import openBook.api.BookingApi
import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReservationId
import openBook.model.BookReserveResponse
import org.example.adapter.CoreBookingAdapter
import org.example.domain.UserAuthority.Companion.LIBRARY_AUTHORITY
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookingApiController(
    private val coreBookingAdapter: CoreBookingAdapter
) : BookingApi {
    override suspend fun v1ReservationBookIdGet(bookId: UUID): ResponseEntity<BookReservationDetailsResponse> =
        coreBookingAdapter.v1GetReservation(bookId)

    @PreAuthorize("hasAuthority('$LIBRARY_AUTHORITY')")
    override suspend fun v1ReservePost(bookReservationId: BookReservationId): ResponseEntity<BookReserveResponse> =
        coreBookingAdapter.v1ReserveBook(bookReservationId.bookId)
}