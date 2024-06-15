package org.example.adapter

import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import openBook.model.InsertBookIntoLibraryRequest

interface CoreCatalogWriterAdapter {
    suspend fun updateBook(book: Book): Boolean
    suspend fun insertBooks(books: InsertBookIntoLibraryRequest): Boolean

    suspend fun createBookInfo(bookInfoCreateDetails: BookInfoCreateDetails): BookInfo
}