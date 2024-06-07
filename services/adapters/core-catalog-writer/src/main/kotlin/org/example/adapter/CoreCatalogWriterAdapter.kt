package org.example.adapter

import openBook.model.Book

interface CoreCatalogWriterAdapter {
    suspend fun updateBook(book: Book): Boolean

}