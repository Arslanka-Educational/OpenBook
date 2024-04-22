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

    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:JsonProperty("city") val city: kotlin.String? = null,

    @get:JsonProperty("street") val street: kotlin.String? = null
) {

}

