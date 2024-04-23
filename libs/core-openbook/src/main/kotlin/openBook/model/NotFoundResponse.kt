package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param code 404 code
 * @param errorMessage Object not found
 */
data class NotFoundResponse(

    @get:JsonProperty("code", required = true) val code: kotlin.Int,

    @get:JsonProperty("errorMessage", required = true) val errorMessage: kotlin.String
) {

}

