package org.example.adapters.`in`.rest.advice

import openBook.model.ErrorResponse
import org.example.domain.model.exceptions.AuthorNotFoundException
import org.example.domain.model.exceptions.LibraryNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class SearchControllerAdvice {
    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler
    fun handleException(exception: Exception): ResponseEntity<ErrorResponse> {
        logger.error(exception.message)
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
    fun handleAuthorNotFoundException(exception: AuthorNotFoundException): ResponseEntity<ErrorResponse> {
        logger.warn(exception.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ErrorResponse(
                    message = exception.message,
                    status = HttpStatus.NOT_FOUND.value()
                )
            )
    }

    @ExceptionHandler
    fun handleLibraryNotFoundException(exception: LibraryNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(
                ErrorResponse(
                    message = exception.message,
                    status = HttpStatus.NOT_FOUND.value()
                )
            )
    }
}

