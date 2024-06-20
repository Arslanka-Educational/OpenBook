package org.example.domain

enum class UserAuthority {
    CLIENT,
    LIBRARY,
    MODERATOR;

    companion object {
        const val CLIENT_AUTHORITY = "CLIENT"
        const val LIBRARY_AUTHORITY = "LIBRARY"
        const val MODERATOR_AUTHORITY = "MODERATOR"
    }
}
