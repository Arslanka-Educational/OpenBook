package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param username 
 * @param password 
 */
data class ClientLoginRequest(

    @get:JsonProperty("username", required = true) val username: kotlin.String,

    @get:JsonProperty("password", required = true) val password: kotlin.String
) {

}

