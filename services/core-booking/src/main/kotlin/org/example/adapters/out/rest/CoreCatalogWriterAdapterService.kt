package org.example.adapters.out.rest

import openBook.model.Book
import org.example.ports.out.rest.CoreCatalogWriterAdapter
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchange

@Service
class CoreCatalogWriterAdapterService(
    private val coreCatalogWriterWebClient: WebClient
) : CoreCatalogWriterAdapter {
    override suspend fun updateBook(book: Book): Boolean = coreCatalogWriterWebClient
        .put()
        .uri("/v1/book/change-details")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(book)
        .awaitExchange {
            if (it.statusCode() == HttpStatus.OK) {
                return@awaitExchange true
            } else if (it.statusCode() == HttpStatus.NOT_FOUND) {
                return@awaitExchange requestInsertBook(book)
            } else {
                throw Exception("Couldn't update book with id ${book.id}")
            }
        }


    private suspend fun requestInsertBook(book: Book): Boolean = coreCatalogWriterWebClient
        .post()
        .uri("/v1/book/insert")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(book)
        .awaitExchange {
            if (it.statusCode().is2xxSuccessful) {
                return@awaitExchange true
            } else {
                throw Exception("Core-catalog-writer service returned server error: ${it.statusCode()}")
            }
        }
}