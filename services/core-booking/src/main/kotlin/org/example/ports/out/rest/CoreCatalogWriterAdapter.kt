package org.example.ports.out.rest

import openBook.model.Book

interface CoreCatalogWriterAdapter {
    suspend fun updateBook(book: Book): Boolean
}