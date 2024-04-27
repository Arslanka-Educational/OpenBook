package openbook.repository

import openBook.model.Book
import openBook.model.BookInfo
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BookRepository(
    val jdbcTemplate: NamedParameterJdbcTemplate
) {
    fun getById(bookId: UUID) {
        jdbcTemplate
    }

    fun getBookInfoListByName(name: String): List<BookInfo> =
        jdbcTemplate.queryForList(
            GET_BOOK_INFO_BY_NAME,
            MapSqlParameterSource()
                .addValue("name", name),
            BookInfo::class.java
        )

    fun getBooksByInfoId(bookInfoId: UUID): MutableList<Book> =
        jdbcTemplate.queryForList(
            GET_BOOK_BY_ID,
            MapSqlParameterSource()
                .addValue("book_info_id", bookInfoId),
            Book::class.java
        )



    companion object {
        private const val GET_BOOK_BY_ID = """
            SELECT id, book_info_id, library_id, publisher_id, status FROM books WHERE books.book_info = (:book_info_id) and status = 'AVAILABLE'
        """

        private const val GET_BOOK_INFO_BY_NAME = """
            SELECT book_info.id, book_info.name, book_info.author_id FROM book_info WHERE name LIKE '%(:name)%'; 
        """
    }
}