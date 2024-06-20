package org.example.service

import kotlinx.coroutines.runBlocking
import org.example.config.UserAuthorities
import org.example.api.dto.UserRegisterRequest
import org.example.domain.AuthorizationUserDetails
import org.example.repository.R2dbcUserRepository
import org.example.repository.util.toUser
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorizationUserDetailsService(
    private val userRepository: R2dbcUserRepository,
    private val userAuthorities: UserAuthorities,
    private val passwordEncoder: PasswordEncoder,
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails = runBlocking {
        userRepository.getByUsername(username)
            ?.let { AuthorizationUserDetails(it, userAuthorities) }
            ?: throw IllegalArgumentException("User with id $username doesn't exists")
    }

    fun registerUser(userRegisterRequest: UserRegisterRequest) = runBlocking {
        val user = userRegisterRequest.toUser(passwordEncoder)
            .copy(id = UUID.randomUUID())

        userRepository.registerUser(user)
        return@runBlocking user
    }
}