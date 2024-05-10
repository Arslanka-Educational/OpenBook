package org.example.ports.out.storage

import java.util.UUID

interface ReservationRepository {
    suspend fun reserveBook(bookId: UUID)
}