package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id 
 * @param name library's name
 * @param city city library located
 */
data class Library(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @get:JsonProperty("city", required = true) val city: kotlin.String
) {

}

