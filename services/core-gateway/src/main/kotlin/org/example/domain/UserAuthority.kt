package org.example.domain

enum class UserAuthority {
    CLIENT,
    LIBRARY,
    MODERATOR;

    companion object {
        const val CLIENT_AUTHORITY = "SCOPE_CLIENT"
        const val LIBRARY_AUTHORITY = "SCOPE_LIBRARY"
        const val MODERATOR_AUTHORITY = "SCOPE_MODERATOR"
    }
}
