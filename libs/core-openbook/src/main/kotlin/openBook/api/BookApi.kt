/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package openBook.api

import openBook.model.BookCreateRequest
import openBook.model.BookDetailsResponse
import openBook.model.NotFoundResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired


import kotlin.collections.List
import kotlin.collections.Map

@RequestMapping("\${api.base-path:}")
interface BookApi {


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/v1/book/create"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun v1BookCreatePost( @RequestBody bookCreateRequest: BookCreateRequest): ResponseEntity<BookDetailsResponse>


    @RequestMapping(
            method = [RequestMethod.GET],
            value = ["/v1/book/details/{book_id}"],
            produces = ["application/json"]
    )
    fun v1BookDetailsBookIdGet( @PathVariable("book_id") bookId: kotlin.String): ResponseEntity<BookDetailsResponse>
}