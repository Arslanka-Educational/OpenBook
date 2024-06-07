package org.example.ports.out.storage

import openBook.model.Library

interface LibraryCreationRepository {
    suspend fun createLibrary(library: Library)
}