package openBook.service

import openBook.api.V1CoreOpenBookService
import openBook.model.*
import org.springframework.stereotype.Service

@Service
class V1CoreOpenBookServiceImpl : V1CoreOpenBookService {
    override fun v1AuthorCreatePost(authorCreateRequest: AuthorCreateRequest): AuthorDetailsResponse {
        TODO("Not yet implemented")
    }

    override fun v1AuthorDetailsAuthorIdGet(authorId: String): AuthorDetailsResponse {
        TODO("Not yet implemented")
    }

    override fun v1BookCreatePost(bookCreateRequest: BookCreateRequest): BookDetailsResponse {
        TODO("Not yet implemented")
    }

    override fun v1BookDetailsBookIdGet(bookId: String): BookDetailsResponse {
        TODO("Not yet implemented")
    }

    override fun v1LibraryCreatePost(libraryCreateRequest: LibraryCreateRequest): LibraryDetailsResponse {
        TODO("Not yet implemented")
    }

    override fun v1LibraryDetailsLibraryIdGet(libraryId: String): LibraryDetailsResponse {
        TODO("Not yet implemented")
    }
}