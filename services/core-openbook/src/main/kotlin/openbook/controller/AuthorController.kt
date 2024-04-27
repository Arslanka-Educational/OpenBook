package openbook.controller

import openBook.api.AuthorApi
import openBook.model.AuthorDetailsResponse
import openbook.service.AuthorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class AuthorController(
    val service: AuthorService
) : AuthorApi {
    override fun v1AuthorDetailsAuthorIdGet(authorId: UUID): ResponseEntity<AuthorDetailsResponse> {
        val author = service.getAuthorDetails(authorId = authorId)
        return ResponseEntity.ok().body(author)
    }
}