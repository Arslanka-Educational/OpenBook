package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param reservedDate 
 * @param reservationExpirationDate 
 */
data class BookReserveResponse(

    @get:JsonProperty("reserved_date") val reservedDate: java.time.LocalDate? = null,

    @get:JsonProperty("reservation_expiration_date") val reservationExpirationDate: java.time.LocalDate? = null
) {

}

