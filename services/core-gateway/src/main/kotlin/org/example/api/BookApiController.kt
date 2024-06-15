package org.example.api

import openBook.api.BookApi
import openBook.model.BookGetByInfoIdResponse
import openBook.model.BookGetByNameResponse
import openBook.model.BookInfo
import org.example.CoreCatalogAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookApiController(
    private val coreCatalogAdapter: CoreCatalogAdapter
) : BookApi {
    override suspend fun v1BookByInfoBookInfoIdGet(bookInfoId: UUID): ResponseEntity<BookGetByInfoIdResponse> =
        ResponseEntity.ok().body(coreCatalogAdapter.getBooksByInfo(bookInfoId))

    override suspend fun v1BookByNameBookNameGet(bookName: String): ResponseEntity<BookGetByNameResponse> =
        ResponseEntity.ok().body(coreCatalogAdapter.getBooksByName(bookName))

    override suspend fun v1BookInfoDetailsBookInfoIdGet(bookInfoId: UUID): ResponseEntity<BookInfo> =
        ResponseEntity.ok().body(coreCatalogAdapter.getBookInfoDetails(bookInfoId))
}