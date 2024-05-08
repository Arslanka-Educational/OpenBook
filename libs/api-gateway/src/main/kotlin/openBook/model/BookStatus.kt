package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.JsonProperty

/**
* 
* Values: aVAILABLE,uNAVAILABLE
*/
enum class BookStatus(val value: kotlin.String) {

    @JsonProperty("AVAILABLE") aVAILABLE("AVAILABLE"),
    @JsonProperty("UNAVAILABLE") uNAVAILABLE("UNAVAILABLE")
}

