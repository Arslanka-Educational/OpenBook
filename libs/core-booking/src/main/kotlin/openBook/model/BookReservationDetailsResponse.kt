package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param bookId 
 * @param reservedDate 
 * @param reservationExpirationDate 
 */
data class BookReservationDetailsResponse(

    @get:JsonProperty("book_id", required = true) val bookId: java.util.UUID,

    @get:JsonProperty("reserved_date", required = true) val reservedDate: java.time.OffsetDateTime,

    @get:JsonProperty("reservation_expiration_date", required = true) val reservationExpirationDate: java.time.OffsetDateTime
) {

}

