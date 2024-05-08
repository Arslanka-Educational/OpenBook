package org.example.domain.services

import openBook.model.Book
import openBook.model.BookInfo
import org.example.ports.`in`.BookSearchUseCase
import org.example.ports.out.BookRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookSearchService(
    private val bookRepository: BookRepository
) : BookSearchUseCase {
    override suspend fun findBookInfoByName(bookName: String): List<BookInfo> {
        return bookRepository.findBooksInfoByName(bookName)
    }

    override suspend fun getBooksByInfoId(bookInfoId: UUID): List<Book> {
        return bookRepository.findBooksByInfoId(bookInfoId)
    }
}