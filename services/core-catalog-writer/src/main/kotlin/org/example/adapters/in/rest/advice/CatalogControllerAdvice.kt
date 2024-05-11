package org.example.adapters.`in`.rest.advice

import openBook.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CatalogControllerAdvice {
    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<ErrorResponse> {
        println(exception.message)
        exception.printStackTrace()
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                ErrorResponse(
                    message = "There was an Internal Server Error, try again",
                    status = HttpStatus.INTERNAL_SERVER_ERROR.value()
                )
            )
    }
}