package org.example.adapters.`in`.rest

import openBook.api.LibraryApi
import openBook.model.LibraryDetailsResponse
import org.example.ports.`in`.LibrarySearchUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class LibrarySearchController(
    private val libraryService: LibrarySearchUseCase
) : LibraryApi {
    override suspend fun v1LibraryDetailsLibraryIdGet(libraryId: UUID): ResponseEntity<LibraryDetailsResponse> {
        return ResponseEntity.ok().body(libraryService.getLibraryDetails(libraryId))
    }
}