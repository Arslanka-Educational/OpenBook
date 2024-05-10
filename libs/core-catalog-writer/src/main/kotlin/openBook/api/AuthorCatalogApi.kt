/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package openBook.api

import openBook.model.Author
import openBook.model.AuthorCreateDetails
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
interface AuthorCatalogApi {


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/v1/author/create"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    suspend fun v1AuthorCreatePost( @RequestBody authorCreateDetails: AuthorCreateDetails): ResponseEntity<Author>
}
