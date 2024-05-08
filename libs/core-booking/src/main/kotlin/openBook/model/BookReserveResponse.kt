package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param reservedDate 
 * @param reservationExpirationDate 
 */
data class BookReserveResponse(

    @get:JsonProperty("reserved_date", required = true) val reservedDate: java.time.LocalDate,

    @get:JsonProperty("reservation_expiration_date", required = true) val reservationExpirationDate: java.time.LocalDate
) {

}

