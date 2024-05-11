package org.example.ports.`in`

import openBook.model.BookReserveResponse
import java.util.*

interface BookReservationUseCase {
    suspend fun reserveBook(bookId: UUID): BookReserveResponse

    suspend fun removeReservation(bookId: UUID): Boolean
}