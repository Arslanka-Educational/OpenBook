package org.example.domain.services

import openBook.model.Library
import org.example.domain.model.exceptions.LibraryNotFoundException
import org.example.ports.out.rest.CoreSearchAdapter
import org.springframework.stereotype.Service
import java.util.*

@Service
class LibrarySearchService(
    private val coreSearchAdapter: CoreSearchAdapter
) {
    suspend fun getLibraryById(libraryId: UUID): Library? {
        return coreSearchAdapter.getLibraryById(libraryId)
            ?: throw LibraryNotFoundException("Library with id: $libraryId not found")
    }
}