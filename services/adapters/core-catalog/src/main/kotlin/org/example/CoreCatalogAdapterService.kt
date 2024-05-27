package org.example

import openBook.model.*
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import java.util.*

class CoreCatalogAdapterService(
    private val coreCatalogUrl: String,
    private val coreCatalogWebClient: WebClient = WebClient.builder().baseUrl(coreCatalogUrl).build(),
) : CoreCatalogAdapter {
    override suspend fun getBooksByName(name: String): BookGetByNameResponse = coreCatalogWebClient
        .get()
        .uri("/v1/book/by-name/$name")
        .retrieve()
        .awaitBody<BookGetByNameResponse>()

    override suspend fun getBookInfoDetails(bookInfoId: UUID): BookInfo = coreCatalogWebClient
        .get()
        .uri("/v1/book/info-details/$bookInfoId")
        .retrieve()
        .awaitBody<BookInfo>()

    override suspend fun getBooksByInfo(bookInfoId: UUID): BookGetByInfoIdResponse = coreCatalogWebClient
        .get()
        .uri("/v1/book/by-info/$bookInfoId")
        .retrieve()
        .awaitBody<BookGetByInfoIdResponse>()

    override suspend fun getAuthorDetails(authorId: UUID): Author = coreCatalogWebClient
        .get()
        .uri("/v1/author/details/$authorId")
        .retrieve()
        .awaitBody<Author>()

    override suspend fun getLibraryDetails(libraryId: UUID): Library = coreCatalogWebClient
        .get()
        .uri("/v1/library/details/$libraryId")
        .retrieve()
        .awaitBody<Library>()
}