package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param name author's name
 */
data class AuthorCreateRequest(

    @get:JsonProperty("name", required = true) val name: kotlin.String
) {

}

