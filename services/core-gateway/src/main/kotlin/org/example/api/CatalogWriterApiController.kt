package org.example.api

import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import openBook.model.InsertBookIntoLibraryRequest
import org.example.adapter.CoreCatalogWriterAdapter
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class CatalogWriterApiController(
    private val coreCatalogWriterAdapter: CoreCatalogWriterAdapter
) {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/v1/book/create-book-info"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    @PreAuthorize("hasAuthority('MODERATOR')")
    suspend fun v1BookCreateBookInfoPost(@RequestBody bookInfoCreateDetails: BookInfoCreateDetails): ResponseEntity<BookInfo> =
        ResponseEntity.ok().body(coreCatalogWriterAdapter.createBookInfo(bookInfoCreateDetails))


    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/v1/book/insert"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    @PreAuthorize("hasAuthority('MODERATOR')")
    suspend fun v1BookInsertPost(@RequestBody insertBookIntoLibraryRequest: InsertBookIntoLibraryRequest): ResponseEntity<Boolean> =
        ResponseEntity.ok().body(coreCatalogWriterAdapter.insertBooks(insertBookIntoLibraryRequest))

}