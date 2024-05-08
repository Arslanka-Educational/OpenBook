package org.example.domain.services

import openBook.model.Library
import org.example.domain.model.exceptions.LibraryNotFoundException
import org.example.ports.`in`.LibrarySearchUseCase
import org.example.ports.out.LibraryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class LibrarySearchService(
    private val libraryRepository: LibraryRepository
) : LibrarySearchUseCase {
    override suspend fun getLibraryDetails(libraryId: UUID): Library {
        val library = libraryRepository.findById(libraryId)
            ?: throw LibraryNotFoundException("Library with id: $libraryId not found")

        return Library(
            id = library.id,
            name = library.name,
            city = library.city
        )
    }
}