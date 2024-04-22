package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id 
 * @param name library's name
 * @param city city library located
 * @param street 
 */
data class LibraryDetailsResponse(

    @get:JsonProperty("id") val id: java.util.UUID? = null,

    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:JsonProperty("city") val city: kotlin.String? = null,

    @get:JsonProperty("street") val street: kotlin.String? = null
) {

}

