package org.example.adapter

import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReserveResponse
import java.util.UUID

interface CoreBookingAdapter {
    suspend fun v1ReserveBook(bookId: UUID) : BookReserveResponse

    suspend fun v1GetReservation(bookId: UUID): BookReservationDetailsResponse
}