package org.example.ports.out

import org.example.domain.model.Library
import java.util.*

interface LibraryRepository {
    suspend fun findById(libraryId: UUID): Library?
}