package org.example.ports.`in`.useCases

import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import java.util.*

interface BooksHandlingUseCase {
    suspend fun insertBooksListViaLibraryId(libraryId: UUID, booksList: List<BookInfoCreateDetails>)

    suspend fun createBookInfo(bookInfoCreateDetails: BookInfoCreateDetails): BookInfo

    suspend fun changeBookDetails(book: Book): Book
}