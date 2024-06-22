package org.example.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.example.api.dto.UserRegisterRequest
import org.example.domain.AuthorizationUserDetails
import org.example.domain.User
import org.example.service.AuthorizationUserDetailsService
import org.example.service.JwtService
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.base-path:}")
class ClientApiController(
    private val userService: AuthorizationUserDetailsService,
    private val jwtService: JwtService,
) {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/v1/client/login"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    suspend fun v1ClientLoginPost(authentication: Authentication): ResponseEntity<String> {
        val userDetails = authentication.principal as AuthorizationUserDetails
        return ResponseEntity.ok().body(jwtService.generateToken(userDetails))
    }

    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/v1/client/register"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    suspend fun v1ClientRegisterPost(@RequestBody userRegisterRequest: UserRegisterRequest): ResponseEntity<User> = runBlocking {
        ResponseEntity.ok().body(userService.registerUser(userRegisterRequest))
    }
}