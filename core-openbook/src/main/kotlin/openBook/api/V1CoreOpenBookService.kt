package openBook.api

import openBook.model.AuthorCreateRequest
import openBook.model.AuthorDetailsResponse
import openBook.model.BookCreateRequest
import openBook.model.BookDetailsResponse
import openBook.model.LibraryCreateRequest
import openBook.model.LibraryDetailsResponse
import openBook.model.NotFoundResponse

interface V1CoreOpenBookService {

    /**
     * POST /v1/author/create
     *
     * @param authorCreateRequest  (required)
     * @return OK (status code 200)
     * @see V1CoreOpenBook#v1AuthorCreatePost
     */
    fun v1AuthorCreatePost(authorCreateRequest: AuthorCreateRequest): AuthorDetailsResponse

    /**
     * GET /v1/author/details/{author_id}
     *
     * @param authorId  (required)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     * @see V1CoreOpenBook#v1AuthorDetailsAuthorIdGet
     */
    fun v1AuthorDetailsAuthorIdGet(authorId: kotlin.String): AuthorDetailsResponse

    /**
     * POST /v1/book/create
     *
     * @param bookCreateRequest  (required)
     * @return OK (status code 200)
     * @see V1CoreOpenBook#v1BookCreatePost
     */
    fun v1BookCreatePost(bookCreateRequest: BookCreateRequest): BookDetailsResponse

    /**
     * GET /v1/book/details/{book_id}
     *
     * @param bookId  (required)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     * @see V1CoreOpenBook#v1BookDetailsBookIdGet
     */
    fun v1BookDetailsBookIdGet(bookId: kotlin.String): BookDetailsResponse

    /**
     * POST /v1/library/create
     *
     * @param libraryCreateRequest  (required)
     * @return OK (status code 200)
     * @see V1CoreOpenBook#v1LibraryCreatePost
     */
    fun v1LibraryCreatePost(libraryCreateRequest: LibraryCreateRequest): LibraryDetailsResponse

    /**
     * GET /v1/library/details/{library_id}
     *
     * @param libraryId  (required)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     * @see V1CoreOpenBook#v1LibraryDetailsLibraryIdGet
     */
    fun v1LibraryDetailsLibraryIdGet(libraryId: kotlin.String): LibraryDetailsResponse
}
