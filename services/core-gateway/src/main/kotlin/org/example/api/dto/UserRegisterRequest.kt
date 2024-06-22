package org.example.api.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.example.domain.UserType

data class UserRegisterRequest(
    @JsonProperty("name") val name: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("user_type") val userType: UserType
)
