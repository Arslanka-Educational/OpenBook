package org.example.domain.services

import openBook.model.LibraryDetailsResponse
import org.example.domain.model.exceptions.LibraryNotFoundException
import org.example.ports.`in`.LibrarySearchUseCase
import org.example.ports.out.LibraryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class LibrarySearchService(
    private val libraryRepository: LibraryRepository
) : LibrarySearchUseCase {
    override suspend fun getLibraryDetails(libraryId: UUID): LibraryDetailsResponse {
        val library = libraryRepository.findById(libraryId)
            ?: throw LibraryNotFoundException("Library with id: $libraryId not found")

        return LibraryDetailsResponse(
            id = library.id,
            name = library.name,
            city = library.city
        )
    }
}