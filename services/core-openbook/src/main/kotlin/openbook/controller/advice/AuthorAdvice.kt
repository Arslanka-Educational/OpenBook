package openbook.controller.advice

import openbook.exceptions.AuthorNotFoundException
import openbook.model.responses.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class AuthorAdvice : ResponseEntityExceptionHandler() {
    @ExceptionHandler(AuthorNotFoundException::class)
    fun handleNotFoundException(e: AuthorNotFoundException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            ErrorResponse(
                message = e.message,
                status = HttpStatus.NOT_FOUND.value()
            )
        )

}