package openbook.controller

import openBook.api.LibraryApi
import openBook.model.LibraryDetailsResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class LibraryController : LibraryApi {

    override fun v1LibraryDetailsLibraryIdGet(libraryId: UUID): ResponseEntity<LibraryDetailsResponse> {
        TODO("Not yet implemented")
    }
}