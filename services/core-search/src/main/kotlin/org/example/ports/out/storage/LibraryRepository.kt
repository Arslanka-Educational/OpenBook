package org.example.ports.out.storage

import openBook.model.Library
import java.util.*

interface LibraryRepository {
    suspend fun findById(libraryId: UUID): Library?
}