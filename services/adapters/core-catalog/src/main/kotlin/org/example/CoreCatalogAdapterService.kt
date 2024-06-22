package org.example

import kotlinx.coroutines.runBlocking
import openBook.model.*
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

class CoreCatalogAdapterService(
    private val coreCatalogUrl: String,
    private val restTemplate: RestTemplate = RestTemplate(),
) : CoreCatalogAdapter {
    override suspend fun getBooksByName(name: String): ResponseEntity<BookGetByNameResponse> = runBlocking {
        val uri = createBuilder("/v1/book/by-name/$name")

        return@runBlocking restTemplate.getForEntity(
            uri.toUriString(),
            BookGetByNameResponse::class.java
        )
    }

    override suspend fun getBookInfoDetails(bookInfoId: UUID): ResponseEntity<BookInfo> = runBlocking {
        val uri = createBuilder("/v1/book/info-details/$bookInfoId")

        return@runBlocking restTemplate.getForEntity(
            uri.toUriString(),
            BookInfo::class.java
        )
    }

    override suspend fun getBooksByInfo(bookInfoId: UUID): ResponseEntity<BookGetByInfoIdResponse> = runBlocking {
        val uri = createBuilder("/v1/book/by-info/$bookInfoId")

        return@runBlocking restTemplate.getForEntity(
            uri.toUriString(),
            BookGetByInfoIdResponse::class.java
        )
    }

    override suspend fun getAuthorDetails(authorId: UUID): ResponseEntity<Author> = runBlocking {
        val uri = createBuilder("/v1/author/details/$authorId")
        return@runBlocking restTemplate.getForEntity(
            uri.toUriString(),
            Author::class.java
        )
    }

    override suspend fun getLibraryDetails(libraryId: UUID): ResponseEntity<Library> = runBlocking {
        val uri = createBuilder("/v1/library/details/$libraryId")

        return@runBlocking restTemplate.getForEntity(
            uri.toUriString(),
            Library::class.java
        )
    }

    private fun createBuilder(method: String): UriComponentsBuilder {
        return UriComponentsBuilder.fromHttpUrl(coreCatalogUrl).path(method)
    }
}