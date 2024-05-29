package org.example.adapters.`in`.rest

import openBook.api.BookCatalogApi
import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import openBook.model.InsertBookIntoLibraryRequest
import org.example.ports.`in`.useCases.BooksHandlingUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class BookCatalogController(
    private val booksHandlingUseCase: BooksHandlingUseCase
) : BookCatalogApi {
    override suspend fun v1BookChangeDetailsPut(book: Book): ResponseEntity<Book> {
        return ResponseEntity.ok().body(booksHandlingUseCase.changeBookDetails(book))
    }

    override suspend fun v1BookCreateBookInfoPost(bookInfoCreateDetails: BookInfoCreateDetails): ResponseEntity<BookInfo> {
        return ResponseEntity.ok().body(
            booksHandlingUseCase.createBookInfo(bookInfoCreateDetails)
        )
    }

    override suspend fun v1BookInsertPost(insertBookIntoLibraryRequest: InsertBookIntoLibraryRequest): ResponseEntity<Boolean> {
        booksHandlingUseCase.insertBooksListViaLibraryId(
            libraryId = insertBookIntoLibraryRequest.libraryId,
            booksList = insertBookIntoLibraryRequest.booksList
        )
        return ResponseEntity.ok().body(true)
    }
}