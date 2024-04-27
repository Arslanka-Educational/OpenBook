package openbook.repository

import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.Timestamp
import java.time.Instant
import java.util.*

@Repository
class BookRepository(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
) {
    @Value("\${spring.application.reservation_expiration_time}")
    private val reservationExpirationTime: Long = 2419200000

    fun getBookById(bookId: UUID): Book? =
        jdbcTemplate.queryForObject(
            GET_BOOK_BY_ID,
            MapSqlParameterSource()
                .addValue("book_id", bookId),
            Book::class.java
        )

    fun getBookInfoListByName(name: String): List<BookInfo> =
        jdbcTemplate.queryForList(
            GET_BOOK_INFO_BY_NAME,
            MapSqlParameterSource()
                .addValue("name", name),
            BookInfo::class.java
        )

    fun getBooksByInfoId(bookInfoId: UUID): MutableList<Book> =
        jdbcTemplate.queryForList(
            GET_BOOK_BY_INFO_ID,
            MapSqlParameterSource()
                .addValue("book_info_id", bookInfoId),
            Book::class.java
        )

    fun reserveBook(bookId: UUID) {
        jdbcTemplate.update(
            CHANGE_BOOK_STATUS,
            MapSqlParameterSource()
                .addValue("status", BookStatus.uNAVAILABLE.value)
                .addValue("book_id", bookId)
        )
        jdbcTemplate.update(
            INSERT_RESERVATION_BY_ID,
            MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("book_id", bookId)
                .addValue("reservation_date", Timestamp.from(Instant.now()))
                .addValue(
                    "reservation_expiration_date",
                    Timestamp.from(Instant.now().plusMillis(reservationExpirationTime))
                )
        )
    }


    companion object {
        private const val INSERT_RESERVATION_BY_ID = """
            INSERT INTO reservation (id, book_id, reservation_date, reservation_expiration_date) 
            VALUES(:id, :book_id, :reservation_date, :reservation_expiration_date) 
        """

        private const val CHANGE_BOOK_STATUS = """
            UPDATE books SET status = (:status) WHERE id = (:book_id)
        """

        private const val GET_BOOK_BY_ID = """
            SELECT id, book_info_id, library_id, publisher_id, status FROM books WHERE books.id = (:book_id)
        """

        private const val GET_BOOK_BY_INFO_ID = """
            SELECT id, book_info_id, library_id, publisher_id, status FROM books WHERE books.book_info = (:book_info_id) and status = 'AVAILABLE'
        """

        private const val GET_BOOK_INFO_BY_NAME = """
            SELECT book_info.id, book_info.name, book_info.author_id FROM book_info WHERE name LIKE '%(:name)%'; 
        """
    }
}