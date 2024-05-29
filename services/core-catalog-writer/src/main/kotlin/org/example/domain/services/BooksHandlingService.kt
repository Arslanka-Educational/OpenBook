package org.example.domain.services

import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import openBook.model.BookStatus
import org.example.ports.`in`.useCases.BooksHandlingUseCase
import org.example.ports.out.storage.BooksHandlingRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class BooksHandlingService(
    private val booksHandlingRepository: BooksHandlingRepository
) : BooksHandlingUseCase {

    @Transactional
    override suspend fun insertBooksListViaLibraryId(libraryId: UUID, booksList: List<BookInfoCreateDetails>) {
        val bookInfoToCreation = mutableListOf<BookInfoCreateDetails>()
        val bookInfoMap = booksList.mapNotNull {
            val bookInfo: BookInfo? = booksHandlingRepository.getBookInfo(it)
            bookInfo ?: bookInfoToCreation.add(it)

            bookInfo?.let { info ->
                info.id to it
            }
        }.groupBy({ it.first }, { it.second }).toMutableMap()

        bookInfoToCreation.forEach {
            val bookInfo = BookInfo(
                id = UUID.randomUUID(),
                name = it.name,
                authorId = it.authorId,
                publisherId = it.publisherId
            )
            booksHandlingRepository.createBookInfo(bookInfo)
            bookInfoMap[bookInfo.id] = listOf(it)
        }

        bookInfoMap.forEach {
            booksHandlingRepository.insertBooksListIntoLibrary(
                booksList = it.value.map { _ ->
                    Book(
                        id = UUID.randomUUID(),
                        libraryId = libraryId,
                        status = BookStatus.aVAILABLE,
                        bookInfoId = it.key
                    )
                },
                libraryId = libraryId
            )
        }
    }

    override suspend fun createBookInfo(bookInfoCreateDetails: BookInfoCreateDetails): BookInfo {
        val bookInfo = BookInfo(
            id = UUID.randomUUID(),
            name = bookInfoCreateDetails.name,
            authorId = bookInfoCreateDetails.authorId,
            publisherId = bookInfoCreateDetails.publisherId
        )
        booksHandlingRepository.createBookInfo(bookInfo)

        return bookInfo
    }

    @Transactional
    override suspend fun changeBookDetails(book: Book): Book {
        val bookInstance = booksHandlingRepository.getBookById(book.id)
        val resBook = bookInstance?.let {
            Book(
                id = book.id,
                bookInfoId = bookInstance.bookInfoId,
                libraryId = book.libraryId ?: bookInstance.libraryId,
                status = book.status ?: bookInstance.status,
            )
        } ?: book
        booksHandlingRepository.changeBookDetails(resBook)
        return book
    }
}