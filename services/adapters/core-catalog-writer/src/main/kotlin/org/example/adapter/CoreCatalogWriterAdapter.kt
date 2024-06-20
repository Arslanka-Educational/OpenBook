package org.example.adapter

import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import openBook.model.InsertBookIntoLibraryRequest
import org.springframework.http.ResponseEntity

interface CoreCatalogWriterAdapter {
    suspend fun updateBook(book: Book): ResponseEntity<Boolean>
    suspend fun insertBooks(books: InsertBookIntoLibraryRequest): ResponseEntity<Boolean>

    suspend fun createBookInfo(bookInfoCreateDetails: BookInfoCreateDetails): ResponseEntity<BookInfo>
}