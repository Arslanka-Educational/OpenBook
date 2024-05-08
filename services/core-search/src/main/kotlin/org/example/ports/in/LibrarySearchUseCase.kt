package org.example.ports.`in`

import openBook.model.LibraryDetailsResponse
import java.util.UUID

interface LibrarySearchUseCase {
    suspend fun getLibraryDetails(libraryId: UUID): LibraryDetailsResponse
}