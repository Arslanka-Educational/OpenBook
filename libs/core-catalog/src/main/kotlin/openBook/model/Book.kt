package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import openBook.model.BookStatus

/**
 * 
 * @param id 
 * @param bookInfoId 
 * @param publisherId key to a book publication id
 * @param libraryId library this is in
 * @param status 
 */
data class Book(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("bookInfoId", required = true) val bookInfoId: java.util.UUID,

    @get:JsonProperty("publisherId", required = true) val publisherId: java.util.UUID,

    @get:JsonProperty("libraryId", required = true) val libraryId: java.util.UUID,

    @get:JsonProperty("status", required = true) val status: BookStatus = BookStatus.uNAVAILABLE
) {

}

