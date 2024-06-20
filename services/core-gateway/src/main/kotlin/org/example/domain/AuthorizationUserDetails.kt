package org.example.domain

import org.example.config.UserAuthorities
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class AuthorizationUserDetails(
    val user: User,
    val userAuthorities: UserAuthorities
) : UserDetails {
    override fun getAuthorities(): List<GrantedAuthority> =
        userAuthorities.authorities[user.userType].orEmpty().map { SimpleGrantedAuthority(it.name) }

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.name

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}