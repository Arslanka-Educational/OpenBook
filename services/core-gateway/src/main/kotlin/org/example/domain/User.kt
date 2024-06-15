package org.example.domain

import java.util.UUID

data class User(
    val id: UUID? = null,
    val name: String,
    val password: String,
    val email: String,
    val userType: UserType
)
