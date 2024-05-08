package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param accessToken 
 * @param refreshToken 
 */
data class JwtLoginResponse(

    @get:JsonProperty("access_token", required = true) val accessToken: kotlin.String,

    @get:JsonProperty("refresh_token", required = true) val refreshToken: kotlin.String
) {

}

