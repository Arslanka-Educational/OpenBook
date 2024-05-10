package org.example.domain.services

import openBook.model.BookInfo
import org.example.domain.model.exceptions.BookInfoNotFoundException
import org.example.ports.out.rest.external.CoreSearchAdapter
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookSearchService(
    private val coreSearchAdapter: CoreSearchAdapter
) {
    suspend fun getBooksByInfoId(bookInfoId: UUID) =
        coreSearchAdapter.getBooksByInfoId(bookInfoId)

    suspend fun getBookInfoByName(name: String) =
        coreSearchAdapter.getBookInfoByName(name)

    suspend fun getBookInfoDetails(bookInfoId: UUID): BookInfo {
        return coreSearchAdapter.getBookInfoDetailsById(bookInfoId)
            ?: throw BookInfoNotFoundException("Book with id: $bookInfoId not found")
    }
}