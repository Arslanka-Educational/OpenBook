package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id 
 * @param name author's name
 */
data class AuthorDetailsResponse(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("name", required = true) val name: kotlin.String
) {

}

