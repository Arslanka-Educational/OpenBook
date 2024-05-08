package org.example.ports.`in`

import openBook.model.Library
import java.util.UUID

interface LibrarySearchUseCase {
    suspend fun getLibraryDetails(libraryId: UUID): Library
}