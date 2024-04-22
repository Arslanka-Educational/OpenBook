package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param error Object not found
 */
data class NotFoundResponse(

    @get:JsonProperty("error") val error: kotlin.String? = null
) {

}

