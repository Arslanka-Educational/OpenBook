package org.example.repository.util

import org.example.api.dto.UserRegisterRequest
import org.example.domain.User
import org.example.domain.UserType
import org.springframework.security.crypto.password.PasswordEncoder

object UserTypeUtil {
    fun fromValue(value: String): UserType {
        return UserType.entries.find { it.typeName == value }
            ?: throw IllegalArgumentException("No enum constant for value: $value")
    }
}

fun UserRegisterRequest.toUser(passwordEncoder: PasswordEncoder) = User(
    name = this.name,
    password = passwordEncoder.encode(this.password),
    email = this.email,
    userType = this.userType,
)