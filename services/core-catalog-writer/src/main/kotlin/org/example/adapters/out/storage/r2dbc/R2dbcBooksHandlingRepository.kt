package org.example.adapters.out.storage.r2dbc

import kotlinx.coroutines.reactive.awaitFirstOrNull
import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import openBook.model.BookStatus
import org.example.ports.out.storage.BooksHandlingRepository
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.r2dbc.core.awaitRowsUpdated
import org.springframework.r2dbc.core.awaitSingleOrNull
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.*

@Repository
class R2dbcBooksHandlingRepository(
    private val databaseClient: DatabaseClient
) : BooksHandlingRepository {
    override suspend fun createBookInfo(bookInfo: BookInfo) {
        databaseClient.sql(CREATE_BOOK_INFO)
            .bind("id", bookInfo.id)
            .bind("name", bookInfo.name)
            .bind("author_id", bookInfo.authorId)
            .bind("publisher_id", bookInfo.publisherId)
            .fetch()
            .awaitRowsUpdated()
    }

    override suspend fun insertBooksListIntoLibrary(booksList: List<Book>, libraryId: UUID) {
        databaseClient.inConnectionMany { conn ->
            val statement = conn.createStatement(INSERT_BOOK_LIST_INTO_LIBRARY)
            booksList.forEach {
                statement
                    .bind("id", it.id)
                    .bind("book_info_id", it.bookInfoId!!)
                    .bind("library_id", libraryId)
                    .bind("status", it.status!!.value)
                    .add()
            }
            return@inConnectionMany Flux.from(statement.execute())
        }
    }

    override suspend fun changeBookDetails(book: Book) {
        databaseClient
            .sql(UPDATE_BOOK_DETAILS_BY_ID)
            .bind("book_info_id", book.bookInfoId!!)
            .bind("library_id", book.libraryId!!)
            .bind("status", book.status!!.value)
            .bind("book_id", book.id)
            .fetch()
            .awaitRowsUpdated()
    }

    override suspend fun getBookInfo(bookInfoDetails: BookInfoCreateDetails): BookInfo? = databaseClient
        .sql(GET_BOOK_INFO_WITHOUT_ID)
        .bind("name", bookInfoDetails.name)
        .bind("author_id", bookInfoDetails.authorId)
        .bind("publisher_id", bookInfoDetails.publisherId)
        .map { r, _ ->
            BookInfo(
                id = r.get("id") as UUID,
                name = r.get("name") as String,
                authorId = r.get("author_id") as UUID,
                publisherId = r.get("publisher_id") as UUID,
            )
        }.all().awaitFirstOrNull()

    override suspend fun getBookById(bookId: UUID): Book? = databaseClient
        .sql(GET_BOOK_BY_ID)
        .bind("id", bookId)
        .map { r, _ ->
            Book(
                id = r.get("id") as UUID,
                libraryId = r.get("library_id") as UUID,
                status = r.get("status") as BookStatus,
                bookInfoId = r.get("id") as UUID
            )
        }.awaitSingleOrNull()


    private companion object {
        private val INSERT_BOOK_LIST_INTO_LIBRARY = """
            INSERT INTO book(id, book_info_id, library_id, status) VALUES (:id, :book_info_id, :library_id, :status)
        """.trimIndent()

        private val UPDATE_BOOK_DETAILS_BY_ID = """
            UPDATE book SET book_info_id=:book_info_id, library_id=:library_id, status=:status WHERE id=:book_id
        """.trimIndent()

        private val CREATE_BOOK_INFO = """
            INSERT INTO book_info(id, name, author_id, publisher_id) VALUES(:id, :name, :author_id, :publisher_id)
        """.trimIndent()

        private val GET_BOOK_INFO_WITHOUT_ID = """
            SELECT id, name, author_id, publisher_id FROM book_info WHERE name like CONCAT('%', :name, '%') 
            AND author_id=:author_id AND publisher_id=:publisher_id
        """.trimIndent()

        private val GET_BOOK_BY_ID = """
            SELECT id, book_info_id, library_id, status FROM book WHERE id=:id 
        """.trimIndent()
    }
}