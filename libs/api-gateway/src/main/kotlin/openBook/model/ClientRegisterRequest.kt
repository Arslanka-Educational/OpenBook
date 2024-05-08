package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param username 
 * @param password 
 * @param email 
 */
data class ClientRegisterRequest(

    @get:JsonProperty("username", required = true) val username: kotlin.String,

    @get:JsonProperty("password", required = true) val password: kotlin.String,

    @get:JsonProperty("email", required = true) val email: kotlin.String
) {

}

