package org.example

import openBook.model.*
import java.util.*

interface CoreCatalogAdapter {
    suspend fun getBooksByName(name: String): BookGetByNameResponse

    suspend fun getBookInfoDetails(bookInfoId: UUID): BookInfo

    suspend fun getBooksByInfo(bookInfoId: UUID): BookGetByInfoIdResponse

    suspend fun getAuthorDetails(authorId: UUID): Author

    suspend fun getLibraryDetails(libraryId: UUID): Library
}