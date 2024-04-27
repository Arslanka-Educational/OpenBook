package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param bookId 
 */
data class V1BookReservationPostRequest(

    @get:JsonProperty("book_id") val bookId: java.util.UUID? = null
) {

}

