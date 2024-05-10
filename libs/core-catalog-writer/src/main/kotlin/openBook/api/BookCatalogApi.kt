/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package openBook.api

import openBook.model.Book
import openBook.model.BookInfo
import openBook.model.BookInfoCreateDetails
import openBook.model.ErrorResponse
import openBook.model.InsertBookIntoLibraryRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired


import kotlinx.coroutines.flow.Flow
import kotlin.collections.List
import kotlin.collections.Map

@RequestMapping("\${api.base-path:}")
interface BookCatalogApi {


    @RequestMapping(
            method = [RequestMethod.PUT],
            value = ["/v1/book/change-details"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    suspend fun v1BookChangeDetailsPut( @RequestBody book: Book): ResponseEntity<Book>


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/v1/book/create-book-info"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    suspend fun v1BookCreateBookInfoPost( @RequestBody bookInfoCreateDetails: BookInfoCreateDetails): ResponseEntity<BookInfo>


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/v1/book/insert"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    suspend fun v1BookInsertPost( @RequestBody insertBookIntoLibraryRequest: InsertBookIntoLibraryRequest): ResponseEntity<kotlin.Boolean>
}