package org.example.ports.`in`

import openBook.model.Book
import openBook.model.BookInfo
import java.util.*

interface BookSearchUseCase {
    suspend fun findBookInfoByName(bookName: String): List<BookInfo>

    suspend fun getBooksByInfoId(bookInfoId: UUID): List<Book>
}