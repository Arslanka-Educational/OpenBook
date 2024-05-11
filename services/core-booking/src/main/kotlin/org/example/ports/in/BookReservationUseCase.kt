package org.example.ports.`in`

import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReserveResponse
import java.util.*

interface BookReservationUseCase {

    suspend fun getReservationDetails(bookId: UUID): BookReservationDetailsResponse
    suspend fun reserveBook(bookId: UUID): BookReserveResponse

    suspend fun removeReservation(bookId: UUID): Boolean
}