package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param errorMessage Object not found
 */
data class NotFoundResponse(

    @get:JsonProperty("errorMessage", required = true) val errorMessage: kotlin.String
) {

}

