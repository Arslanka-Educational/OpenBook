package org.example.api

import openBook.api.ClientApi
import openBook.model.ClientLoginRequest
import openBook.model.ClientRegisterRequest
import openBook.model.JwtLoginResponse
import org.springframework.http.ResponseEntity

class ClientApiController : ClientApi{
    override suspend fun v1ClientLoginPost(clientLoginRequest: ClientLoginRequest): ResponseEntity<JwtLoginResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun v1ClientRegisterPost(clientRegisterRequest: ClientRegisterRequest): ResponseEntity<JwtLoginResponse> {
        TODO("Not yet implemented")
    }
}