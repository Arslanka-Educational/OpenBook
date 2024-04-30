package openbook.adapters.`in`

import openBook.api.LibraryApi
import openBook.model.LibraryDetailsResponse
import openbook.ports.`in`.LibraryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class LibraryController(
    val service: LibraryService
) : LibraryApi {
    override fun v1LibraryDetailsLibraryIdGet(libraryId: UUID): ResponseEntity<LibraryDetailsResponse> {
        TODO("Not yet implemented")
    }
}