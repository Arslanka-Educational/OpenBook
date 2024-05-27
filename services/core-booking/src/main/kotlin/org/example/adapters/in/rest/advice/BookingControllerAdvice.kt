package org.example.adapters.`in`.rest.advice

import openBook.model.ErrorResponse
import org.example.exception.BookNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class BookingControllerAdvice {
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

    @ExceptionHandler
    fun handleException(exception: BookNotFoundException): ResponseEntity<ErrorResponse> {
        println(exception.message)
        exception.printStackTrace()

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ErrorResponse(
                    message = exception.message,
                    status = HttpStatus.NOT_FOUND.value()
                )
            )
    }

}