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

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @get:JsonProperty("booksCount", required = true) val booksCount: kotlin.Int
) {

}

