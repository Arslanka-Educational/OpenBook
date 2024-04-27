package openbook.service

import openBook.model.BookGetByInfoIdResponse
import openbook.repository.BookRepository
import org.springframework.stereotype.Service
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
}
