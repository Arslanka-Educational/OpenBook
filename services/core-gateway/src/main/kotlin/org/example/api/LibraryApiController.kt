package org.example.api

import openBook.api.LibraryApi
import openBook.model.Library
import org.example.CoreCatalogAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class LibraryApiController(
    private val coreCatalogAdapter: CoreCatalogAdapter
) : LibraryApi {
    override suspend fun v1LibraryDetailsLibraryIdGet(libraryId: UUID): ResponseEntity<Library> =
        ResponseEntity.ok().body(coreCatalogAdapter.getLibraryDetails(libraryId))
}