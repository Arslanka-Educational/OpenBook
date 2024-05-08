package org.example.adapters.out.r2dbc

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookStatus
import org.example.ports.out.BookRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class R2dbcBookRepository(
    private val databaseClient: DatabaseClient
) : BookRepository {
    override suspend fun findBooksByInfoId(bookInfoId: UUID): List<Book> =
        withContext(Dispatchers.IO) {
            databaseClient
                .sql(GET_BY_INFO_ID)
                .bind("info_id", bookInfoId)
                .map { r, _ ->
                    Book(
                        id = r.get("id") as UUID,
                        libraryId = r.get("library_id") as UUID,
                        bookInfoId = r.get("book_info_id") as UUID,
                        status = BookStatus.valueOf(r.get("status") as String)
                    )
                }.all()  // Fetch all rows
                .collectList() // Collect all rows into a List<Book>
                .block()
        } ?: mutableListOf()

    override suspend fun findBooksInfoByName(bookName: String): List<BookInfo> =
        withContext(Dispatchers.IO) {
            databaseClient
                .sql(GET_INFO_BY_NAME)
                .bind("name", bookName)
                .map { r, _ ->
                    BookInfo(
                        id = r.get("id") as UUID,
                        name = r.get("name") as String,
                        authorId = r.get("author_id") as UUID,
                        publisherId = r.get("publisher_id") as UUID
                    )
                }.all()  // Fetch all rows
                .collectList() // Collect all rows into a List<Book>
                .block()
        } ?: mutableListOf()

    private companion object {
        private val GET_BY_INFO_ID = """
            SELECT id, book_info_id, library_id, status FROM book where book_info_id = :info_id 
        """.trimIndent()

        private val GET_INFO_BY_NAME = """
            SELECT id, name, author_id, publisher_id FROM book_info WHERE name like CONCAT('%', :name, '%')
        """.trimIndent()
    }
}