package org.example.adapters.out.storage.r2dbc

import openBook.model.Book
import org.example.ports.out.storage.ReservationRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitOneOrNull
import org.springframework.r2dbc.core.awaitRowsUpdated
import org.springframework.stereotype.Repository
import java.sql.Timestamp
import java.time.Instant
import java.util.*

@Repository
class R2dbcReservationRepository(
    private val databaseClient: DatabaseClient
) : ReservationRepository {
    override suspend fun reserveBook(book: Book, reservationDate: Pair<Instant, Instant>): Boolean {
        val rowsInserted = databaseClient
            .sql(RESERVE_BOOK_BY_ID)
            .bind("id", UUID.randomUUID())
            .bind("reservation_date", Timestamp.from(reservationDate.first))
            .bind("reservation_due_date", Timestamp.from(reservationDate.second))
            .bind("book_id", book.id)
            .fetch()
            .awaitRowsUpdated()
        return rowsInserted == 1L
    }

    override suspend fun removeReservation(book: Book): Boolean {
        val rowsDeleted = databaseClient
            .sql(REMOVE_RESERVATION_BY_BOOK_ID)
            .bind("book_id", book.id)
            .fetch()
            .awaitRowsUpdated()
        return rowsDeleted == 1L
    }

    override suspend fun getReservationInfo(book: Book): Pair<UUID, Instant>? = databaseClient
        .sql(GET_RESERVATION_INFO_BY_BOOK_ID)
        .bind("book_id", book.id)
        .map { r, _ ->
            r.get("id") as UUID to r.get("reservation_date") as Instant
        }.awaitOneOrNull()

    private companion object {
        private val GET_RESERVATION_INFO_BY_BOOK_ID = """
            SELECT id, reservation_date, book_id FROM books_reservations WHERE book_id=:book_id
        """.trimIndent()

        private val RESERVE_BOOK_BY_ID = """
            INSERT INTO books_reservations(id, reservation_date, reservation_due_date, book_id) 
            VALUES (:id, :reservation_date, :reservation_due_date, :book_id)
        """.trimIndent()

        private val REMOVE_RESERVATION_BY_BOOK_ID = """
            DELETE FROM books_reservations WHERE book_id=:book_id
        """.trimIndent()
    }
}