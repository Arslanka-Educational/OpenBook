package org.example.ports.out.storage

import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import java.util.UUID

interface BooksHandlingRepository {

    suspend fun createBookInfo(bookInfo: BookInfo)

    suspend fun insertBooksListIntoLibrary(booksList: List<Book>, libraryId: UUID)

    suspend fun changeBookDetails(book: Book)

    suspend fun getBookInfo(bookInfoDetails: BookInfoCreateDetails): BookInfo?

    suspend fun getBookById(bookId: UUID): Book?
}