package org.example.adapters.`in`.rest

import openBook.api.LibraryApi
import openBook.model.Library
import org.example.domain.services.LibrarySearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class LibrarySearchController(
    private val libraryService: LibrarySearchService
) : LibraryApi {
    override suspend fun v1LibraryDetailsLibraryIdGet(libraryId: UUID): ResponseEntity<Library> {
        return ResponseEntity.ok().body(libraryService.getLibraryById(libraryId))
    }
}