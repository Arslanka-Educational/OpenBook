package org.example.adapters.`in`.rest

import openBook.api.LibraryCatalogApi
import openBook.model.Library
import openBook.model.LibraryCreateDetails
import org.example.ports.`in`.useCases.LibraryCreationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class LibraryCatalogController(
    private val libraryCreationUseCase: LibraryCreationUseCase
): LibraryCatalogApi {
    override suspend fun v1LibraryCreatePost(libraryCreateDetails: LibraryCreateDetails): ResponseEntity<Library> {
        val library = libraryCreationUseCase.createLibrary(libraryCreateDetails)
        return ResponseEntity.ok().body(library)
    }
}