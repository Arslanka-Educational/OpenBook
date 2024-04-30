package openbook.adapters.`in`

import openBook.api.AuthorApi
import openBook.model.AuthorDetailsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class AuthorController : AuthorApi {
    override fun v1AuthorDetailsAuthorIdGet(authorId: UUID): ResponseEntity<AuthorDetailsResponse> {
        TODO("Not yet implemented")
    }
}