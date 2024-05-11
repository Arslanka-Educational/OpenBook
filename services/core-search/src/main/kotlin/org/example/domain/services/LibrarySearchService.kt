package org.example.domain.services

import openBook.model.Library
import org.example.ports.`in`.LibrarySearchUseCase
import org.example.ports.out.storage.LibraryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class LibrarySearchService(
    private val libraryRepository: LibraryRepository
) : LibrarySearchUseCase {
    override suspend fun getLibraryDetails(libraryId: UUID): Library? =
        libraryRepository.findById(libraryId)

}