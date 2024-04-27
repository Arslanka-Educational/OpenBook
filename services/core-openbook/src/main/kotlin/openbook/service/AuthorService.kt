package openbook.service

import openBook.model.AuthorDetailsResponse
import openbook.exceptions.AuthorNotFoundException
import openbook.repository.AuthorRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorService(
    private val repository: AuthorRepository
) {
    fun getAuthorDetails(authorId: UUID): AuthorDetailsResponse {
        return repository.getAuthorDetails(authorId)
            ?: throw AuthorNotFoundException("Author with id {$authorId} not found")
    }
}