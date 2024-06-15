package org.example.adapter

import kotlinx.coroutines.runBlocking
import openBook.model.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

class CoreSearchAdapterService(
    private val coreSearchUrl: String,
    private val restTemplate: RestTemplate = RestTemplate(),
) : CoreSearchAdapter {
    override suspend fun getBookInfoByName(name: String): List<BookInfo> = runBlocking {
        val uri = createBuilder("/v1/book/by-name/${name}")
        val response = restTemplate.getForObject(
            uri.toUriString(),
            BookGetByNameResponse::class.java
        ) as BookGetByNameResponse
        return@runBlocking response.booksInfo
    }

    override suspend fun getBooksByInfoId(bookInfoId: UUID): List<Book> = runBlocking {
        val uri = createBuilder("/v1/book/by-info/${bookInfoId}")
        val response = restTemplate.getForObject(
            uri.toUriString(),
            BookGetByInfoIdResponse::class.java
        ) as BookGetByInfoIdResponse
        return@runBlocking response.books
    }

    override suspend fun getBookInfoDetailsById(bookInfoId: UUID): BookInfo? = runBlocking {
        val uri = createBuilder("/v1/book/info-details/${bookInfoId}")
        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            BookInfo::class.java
        )
    }

    override suspend fun getAuthorById(authorId: UUID): Author? = runBlocking {
        val uri = createBuilder("/v1/author/details/${authorId}")
        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            Author::class.java
        )
    }

    override suspend fun getLibraryById(libraryId: UUID): Library? = runBlocking {
        val uri = createBuilder("/v1/library/details/${libraryId}")
        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            Library::class.java
        )
    }

    private fun createBuilder(method: String): UriComponentsBuilder {
        return UriComponentsBuilder.fromHttpUrl(coreSearchUrl).path(method)
    }
}