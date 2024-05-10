package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param name 
 * @param authorId 
 * @param publisherId 
 */
data class BookInfoCreateDetails(

    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @get:JsonProperty("author_id", required = true) val authorId: java.util.UUID,

    @get:JsonProperty("publisher_id", required = true) val publisherId: java.util.UUID
) {

}

