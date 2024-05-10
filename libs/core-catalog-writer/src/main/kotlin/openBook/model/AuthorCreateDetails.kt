package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param name 
 */
data class AuthorCreateDetails(

    @get:JsonProperty("name", required = true) val name: kotlin.String
) {

}

