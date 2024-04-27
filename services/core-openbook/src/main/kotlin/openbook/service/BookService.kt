package openbook.service

import openBook.model.BookGetByInfoIdResponse
import openBook.model.BookReserveResponse
import openBook.model.BookStatus
import openbook.exceptions.BookNotFoundException
import openbook.repository.BookRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class BookService(
    private val repository: BookRepository
) {
    fun getBookInfoListByName(bookName: String) =
        repository.getBookInfoListByName(bookName)

    fun getBooksByInfoId(bookInfoId: UUID): BookGetByInfoIdResponse {
        val books = repository.getBooksByInfoId(bookInfoId)
        return BookGetByInfoIdResponse(
            bookInfoId = bookInfoId,
            books = books
        )
    }

    fun reserveBook(bookId: UUID): BookReserveResponse? {
        val book = repository.getBookById(bookId) ?: throw BookNotFoundException("Book with id {$bookId} not found")
        if (book.status != BookStatus.aVAILABLE) {
            return null
        }
        repository.reserveBook(bookId)
        return BookReserveResponse(
            LocalDate.now(),
            LocalDate.now()
        )
    }
}
