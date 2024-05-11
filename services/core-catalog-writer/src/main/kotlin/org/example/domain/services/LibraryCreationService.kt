package org.example.domain.services

import openBook.model.Library
import openBook.model.LibraryCreateDetails
import org.example.ports.`in`.useCases.LibraryCreationUseCase
import org.example.ports.out.storage.LibraryCreationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class LibraryCreationService(
    private val libraryCreationRepository: LibraryCreationRepository
): LibraryCreationUseCase {
    override suspend fun createLibrary(libraryDetails: LibraryCreateDetails): Library {
        val library = Library(
            id = UUID.randomUUID(),
            name = libraryDetails.name,
            city = libraryDetails.city
        )
        libraryCreationRepository.createLibrary(library)
        return library
    }
}