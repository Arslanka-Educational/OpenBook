package org.example.adapter

import openBook.model.*
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitBodyOrNull
import java.util.*

class CoreSearchAdapterService(
    private val coreSearchUrl: String,
    private val coreSearchWebClient: WebClient = WebClient.builder().baseUrl(coreSearchUrl).build(),
) : CoreSearchAdapter {
    override suspend fun getBookInfoByName(name: String): List<BookInfo> =
        coreSearchWebClient.get()
            .uri("/v1/book/get-by-name/${name}")
            .retrieve()
            .awaitBody<BookGetByNameResponse>().booksInfo

    override suspend fun getBooksByInfoId(bookInfoId: UUID): List<Book> =
        coreSearchWebClient.get()
            .uri("/v1/book/get-by-info/${bookInfoId}")
            .retrieve()
            .awaitBody<BookGetByInfoIdResponse>().books

    override suspend fun getBookInfoDetailsById(bookInfoId: UUID): BookInfo? =
        coreSearchWebClient.get()
            .uri("/v1/book/info-details/${bookInfoId}")
            .retrieve()
            .awaitBodyOrNull()

    override suspend fun getAuthorById(authorId: UUID): Author? =
        coreSearchWebClient.get()
            .uri("/v1/author/details/${authorId}")
            .retrieve()
            .awaitBodyOrNull()

    override suspend fun getLibraryById(libraryId: UUID): Library? =
        coreSearchWebClient.get()
            .uri("/v1/library/details/${libraryId}")
            .retrieve()
            .awaitBodyOrNull()
}