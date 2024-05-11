package org.example.ports.`in`.useCases

import openBook.model.Library
import openBook.model.LibraryCreateDetails

interface LibraryCreationUseCase {
    suspend fun createLibrary(libraryDetails: LibraryCreateDetails): Library
}