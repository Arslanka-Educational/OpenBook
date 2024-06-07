package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param name library's name
 * @param city city library located
 */
data class LibraryCreateDetails(

    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @get:JsonProperty("city", required = true) val city: kotlin.String
) {

}

