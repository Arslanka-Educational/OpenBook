package org.example.ports.out.storage

import openBook.model.Book
import openBook.model.BookInfo
import java.util.*

interface BookRepository {
    suspend fun getBooksByInfoId(bookInfoId: UUID): List<Book>
    suspend fun getBooksInfoByName(bookName: String): List<BookInfo>

    suspend fun getBookInfoDetailsById(bookInfoId: UUID): BookInfo?
}