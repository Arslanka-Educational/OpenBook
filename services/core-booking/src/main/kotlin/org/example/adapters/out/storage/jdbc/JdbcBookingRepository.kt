package org.example.adapters.out.storage.jdbc

import openBook.model.Book
import openBook.model.BookReservationDetailsResponse
import org.example.ports.out.storage.BookingRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.Timestamp
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*

@Repository
class JdbcBookingRepository(
    @Qualifier("coreBookingJdbcTemplate") private val jdbcTemplate: NamedParameterJdbcTemplate,
) : BookingRepository {
    override suspend fun reserveBook(book: Book, reservationDate: Pair<Instant, Instant>) {
        jdbcTemplate.update(
            RESERVE_BOOK_BY_ID,
            MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("reservation_date", Timestamp.from(reservationDate.first))
                .addValue("reservation_due_date", Timestamp.from(reservationDate.second))
                .addValue("book_id", book.id)
        )
    }


    override suspend fun removeReservation(book: Book) {
        jdbcTemplate.update(
            REMOVE_RESERVATION_BY_BOOK_ID,
            MapSqlParameterSource()
                .addValue("book_id", book.id)
        )
    }

    override suspend fun getReservationInfo(bookId: UUID): BookReservationDetailsResponse? =
        jdbcTemplate.query(
            GET_RESERVATION_INFO_BY_BOOK_ID,
            MapSqlParameterSource()
                .addValue("book_id", bookId)
        ) { r, _ ->
            BookReservationDetailsResponse(
                bookId = bookId,
                reservationExpirationDate = convertTimestampToOffsetDateTime(r.getTimestamp("reservation_date")),
                reservedDate = convertTimestampToOffsetDateTime(r.getTimestamp("reservation_due_date")),
            )
        }.firstOrNull()

    private companion object {
        private val GET_RESERVATION_INFO_BY_BOOK_ID = """
            SELECT id, reservation_date, reservation_due_date, book_id FROM books_reservations WHERE book_id=:book_id
        """.trimIndent()

        private val RESERVE_BOOK_BY_ID = """
            INSERT INTO books_reservations(id, reservation_date, reservation_due_date, book_id) 
            VALUES (:id, :reservation_date, :reservation_due_date, :book_id)
        """.trimIndent()

        private val REMOVE_RESERVATION_BY_BOOK_ID = """
            DELETE FROM books_reservations WHERE book_id=:book_id
        """.trimIndent()

        fun convertTimestampToOffsetDateTime(date: Timestamp, offset: ZoneOffset = ZoneOffset.UTC): OffsetDateTime {
            val instant: Instant = date.toInstant()
            return OffsetDateTime.ofInstant(instant, offset)
        }
    }
}