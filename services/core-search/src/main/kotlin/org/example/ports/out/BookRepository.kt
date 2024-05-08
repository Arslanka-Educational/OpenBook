package org.example.ports.out

import openBook.model.Book
import openBook.model.BookInfo
import java.util.UUID

interface BookRepository {
    suspend fun findBooksByInfoId(bookInfoId: UUID) : List<Book>
    suspend fun findBooksInfoByName(bookName: String): List<BookInfo>
}