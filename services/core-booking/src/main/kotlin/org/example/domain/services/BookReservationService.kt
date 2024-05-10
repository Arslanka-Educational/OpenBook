package org.example.domain.services

import openBook.model.BookReserveResponse
import org.example.ports.`in`.BookReserveUseCase
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookReservationService : BookReserveUseCase {
    override suspend fun bookReserve(bookId: UUID): BookReserveResponse {
        TODO("Not yet implemented")
    }
}