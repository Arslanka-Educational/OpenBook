package org.example

import kotlinx.coroutines.runBlocking
import openBook.model.*
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

class CoreCatalogAdapterService(
    private val coreCatalogUrl: String,
    private val restTemplate: RestTemplate = RestTemplate(),
) : CoreCatalogAdapter {
    override suspend fun getBooksByName(name: String): BookGetByNameResponse = runBlocking {
        val uri = createBuilder("/v1/book/by-name/$name")

        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            BookGetByNameResponse::class.java
        ) as BookGetByNameResponse
    }

    override suspend fun getBookInfoDetails(bookInfoId: UUID): BookInfo = runBlocking {
        val uri = createBuilder("/v1/book/info-details/$bookInfoId")

        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            BookInfo::class.java
        ) as BookInfo
    }

    override suspend fun getBooksByInfo(bookInfoId: UUID): BookGetByInfoIdResponse = runBlocking {
        val uri = createBuilder("/v1/book/by-info/$bookInfoId")

        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            BookGetByInfoIdResponse::class.java
        ) as BookGetByInfoIdResponse
    }

    override suspend fun getAuthorDetails(authorId: UUID): Author = runBlocking {
        val uri = createBuilder("/v1/author/details/$authorId")
        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            Author::class.java
        ) as Author
    }

    override suspend fun getLibraryDetails(libraryId: UUID): Library = runBlocking {
        val uri = createBuilder("/v1/library/details/$libraryId")

        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            Library::class.java
        ) as Library
    }

    private fun createBuilder(method: String): UriComponentsBuilder {
        return UriComponentsBuilder.fromHttpUrl(coreCatalogUrl).path(method)
    }
}