package org.example.ports.out.storage

import openBook.model.Book
import openBook.model.BookReservationDetailsResponse
import java.time.Instant
import java.util.*


interface BookingRepository {
    suspend fun reserveBook(book: Book, reservationDate: Pair<Instant, Instant>)

    suspend fun removeReservation(book: Book)

    suspend fun getReservationInfo(bookId: UUID): BookReservationDetailsResponse?

}