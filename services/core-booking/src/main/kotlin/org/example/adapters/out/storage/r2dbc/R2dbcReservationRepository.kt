package org.example.adapters.out.storage.r2dbc

import org.example.ports.out.storage.ReservationRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class R2dbcReservationRepository : ReservationRepository {
    override suspend fun reserveBook(bookId: UUID) {
        TODO("Not yet implemented")
    }

    private companion object {
        private val GET_BOOK_BY_ID = """
            
        """.trimIndent()

        private val RESERVE_BOOK_BY_ID = """
            
        """.trimIndent()
    }
}