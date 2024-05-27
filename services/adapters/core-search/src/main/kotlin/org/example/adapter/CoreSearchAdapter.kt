package org.example.adapter

import openBook.model.Author
import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.Library
import java.util.*

interface CoreSearchAdapter {
    suspend fun getBookInfoByName(name: String): List<BookInfo>

    suspend fun getBooksByInfoId(bookInfoId: UUID): List<Book>

    suspend fun getBookInfoDetailsById(bookInfoId: UUID): BookInfo?

    suspend fun getAuthorById(authorId: UUID): Author?

    suspend fun getLibraryById(libraryId: UUID): Library?
}