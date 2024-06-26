package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param bookId 
 */
data class BookReservationId(

    @get:JsonProperty("book_id", required = true) val bookId: java.util.UUID
) {

}

