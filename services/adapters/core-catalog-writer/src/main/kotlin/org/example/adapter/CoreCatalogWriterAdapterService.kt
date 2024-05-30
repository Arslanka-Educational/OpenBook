package org.example.adapter

import openBook.model.Book
import org.example.exception.BookNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchange

class CoreCatalogWriterAdapterService(
    private val coreCatalogWriterUrl: String,
    private val coreCatalogWriterWebClient: WebClient = WebClient.builder().baseUrl(coreCatalogWriterUrl).build(),
) : CoreCatalogWriterAdapter {
    override suspend fun updateBook(book: Book): Boolean = coreCatalogWriterWebClient
        .put()
        .uri("/v1/book/change-details")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(book)
        .awaitExchange {
            when (it.statusCode()) {
                HttpStatus.OK -> return@awaitExchange true
                HttpStatus.NOT_FOUND -> throw BookNotFoundException("Book with id: ${book.id} wasn't found")
                else -> throw Exception("Couldn't update book with id ${book.id}")
            }
        }
}