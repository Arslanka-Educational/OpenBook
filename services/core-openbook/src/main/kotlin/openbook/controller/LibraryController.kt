package openbook.controller

import openBook.api.LibraryApi
import openBook.model.LibraryCreateRequest
import openBook.model.LibraryDetailsResponse
import org.springframework.http.ResponseEntity

class LibraryController : LibraryApi {
    override fun v1LibraryCreatePost(libraryCreateRequest: LibraryCreateRequest): ResponseEntity<LibraryDetailsResponse> {
        TODO("Not yet implemented")
    }

    override fun v1LibraryDetailsLibraryIdGet(libraryId: String): ResponseEntity<LibraryDetailsResponse> {
        TODO("Not yet implemented")
    }
}