package org.example.ports.`in`

import openBook.model.BookReserveResponse
import java.util.*

interface BookReserveUseCase {
    suspend fun bookReserve(bookId: UUID): BookReserveResponse
}