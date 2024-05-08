package org.example.ports.out

import openBook.model.Library
import java.util.*

interface LibraryRepository {
    suspend fun findById(libraryId: UUID): Library?
}