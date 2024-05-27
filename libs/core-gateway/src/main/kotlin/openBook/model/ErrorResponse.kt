package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param message 
 * @param status 
 */
data class ErrorResponse(

    @get:JsonProperty("message") val message: kotlin.String? = null,

    @get:JsonProperty("status") val status: kotlin.Int? = null
) {

}

