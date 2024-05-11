package org.example.ports.out.storage

import openBook.model.Book
import java.time.Instant
import java.util.*


interface ReservationRepository {
    suspend fun reserveBook(book: Book, reservationDate: Pair<Instant, Instant>): Boolean

    suspend fun removeReservation(book: Book): Boolean

    suspend fun getReservationInfo(book: Book): Pair<UUID, Instant>?

}