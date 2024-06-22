package org.example.api.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException

@ControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound::class)
    fun handleNotFound(exception: HttpClientErrorException.NotFound): ResponseEntity<ErrorResponse> {
        val errorMessage = exception.getResponseBodyAs(ErrorResponse::class.java)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }
}

data class ErrorResponse(val message: String, val status: Int)