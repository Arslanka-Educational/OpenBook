package org.example.adapter

import kotlinx.coroutines.runBlocking
import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import openBook.model.InsertBookIntoLibraryRequest
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

class CoreCatalogWriterAdapterService(
    private val coreCatalogWriterUrl: String,
    private val restTemplate: RestTemplate = RestTemplate(),
) : CoreCatalogWriterAdapter {
    override suspend fun updateBook(book: Book): ResponseEntity<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun insertBooks(books: InsertBookIntoLibraryRequest): ResponseEntity<Boolean> = runBlocking {
        val uri = createBuilder("/v1/book/insert")
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val request = HttpEntity(books, headers)

        return@runBlocking restTemplate.postForEntity(
            uri.toUriString(),
            request,
            Boolean::class.java
        )
    }

    override suspend fun createBookInfo(bookInfoCreateDetails: BookInfoCreateDetails): ResponseEntity<BookInfo> =
        runBlocking {
            val uri = createBuilder("/v1/book/create-book-info")
            val headers = HttpHeaders()
            headers.contentType = MediaType.APPLICATION_JSON
            val request = HttpEntity(bookInfoCreateDetails, headers)

            return@runBlocking restTemplate.postForEntity(
                uri.toUriString(),
                request,
                BookInfo::class.java
            )
        }

    private fun createBuilder(method: String): UriComponentsBuilder {
        return UriComponentsBuilder.fromHttpUrl(coreCatalogWriterUrl).path(method)
    }
}