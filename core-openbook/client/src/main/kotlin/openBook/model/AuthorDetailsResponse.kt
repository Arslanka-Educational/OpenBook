package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id 
 * @param name author's name
 * @param booksCount count of author's published books
 */
data class AuthorDetailsResponse(

    @get:JsonProperty("id") val id: java.util.UUID? = null,

    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:JsonProperty("booksCount") val booksCount: kotlin.Int? = null
) {

}

