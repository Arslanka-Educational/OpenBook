package org.example

import openBook.model.*
import org.springframework.http.ResponseEntity
import java.util.*

interface CoreCatalogAdapter {
    suspend fun getBooksByName(name: String): ResponseEntity<BookGetByNameResponse>

    suspend fun getBookInfoDetails(bookInfoId: UUID): ResponseEntity<BookInfo>

    suspend fun getBooksByInfo(bookInfoId: UUID): ResponseEntity<BookGetByInfoIdResponse>

    suspend fun getAuthorDetails(authorId: UUID): ResponseEntity<Author>

    suspend fun getLibraryDetails(libraryId: UUID): ResponseEntity<Library>
}