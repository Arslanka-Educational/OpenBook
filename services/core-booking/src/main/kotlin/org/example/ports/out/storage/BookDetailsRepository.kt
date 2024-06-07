package org.example.ports.out.storage

import openBook.model.Book
import java.util.*

interface BookDetailsRepository {
    suspend fun updateBook(book: Book)

    suspend fun getBookDetails(bookId: UUID) : Book?
}