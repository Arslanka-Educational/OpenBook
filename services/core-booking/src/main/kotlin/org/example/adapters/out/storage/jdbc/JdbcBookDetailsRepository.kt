package org.example.adapters.out.storage.jdbc

import openBook.model.Book
import openBook.model.BookStatus
import org.example.ports.out.storage.BookDetailsRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class JdbcBookDetailsRepository(
    @Qualifier("coreCatalogJdbcTemplate") private val jdbcTemplate: NamedParameterJdbcTemplate,
) : BookDetailsRepository {

    override suspend fun getBookDetails(bookId: UUID): Book? = jdbcTemplate.query(
        GET_BOOK_BY_ID,
        MapSqlParameterSource()
            .addValue("id", bookId)
    ) { r, _ ->
        Book(
            id = UUID.fromString(r.getString("id")),
            libraryId = UUID.fromString(r.getString("library_id")),
            status = fromValue(r.getString("status")),
            bookInfoId = UUID.fromString(r.getString("id")),
        )
    }.firstOrNull()

    override suspend fun updateBook(book: Book) {
        jdbcTemplate.update(
            UPDATE_BOOK_DETAILS_BY_ID,
            MapSqlParameterSource()
                .addValue("book_id", book.id)
                .addValue("library_id", book.libraryId!!)
                .addValue("status", book.status!!.value)
        )
    }

    private companion object {
        private val UPDATE_BOOK_DETAILS_BY_ID = """
            UPDATE book SET library_id=:library_id, status=:status::booking_status WHERE id=:book_id
        """.trimIndent()

        private val GET_BOOK_BY_ID = """
            SELECT id, book_info_id, library_id, status FROM book WHERE id=:id
        """.trimIndent()

        fun fromValue(value: String): BookStatus {
            return BookStatus.entries.find { it.value == value }
                ?: throw IllegalArgumentException("No enum constant for value: $value")
        }
    }
}