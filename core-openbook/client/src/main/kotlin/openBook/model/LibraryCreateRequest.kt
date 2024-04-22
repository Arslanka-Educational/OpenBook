package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param name library's name
 * @param city city library located
 * @param street 
 */
data class LibraryCreateRequest(

    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @get:JsonProperty("city", required = true) val city: kotlin.String,

    @get:JsonProperty("street", required = true) val street: kotlin.String
) {

}

