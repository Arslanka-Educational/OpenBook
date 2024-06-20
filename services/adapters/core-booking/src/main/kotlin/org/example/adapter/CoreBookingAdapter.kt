package org.example.adapter

import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReserveResponse
import org.springframework.http.ResponseEntity
import java.util.UUID

interface CoreBookingAdapter {
    suspend fun v1ReserveBook(bookId: UUID) : ResponseEntity<BookReserveResponse>

    suspend fun v1GetReservation(bookId: UUID): ResponseEntity<BookReservationDetailsResponse>
}