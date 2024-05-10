package org.example.adapters.`in`.rest

import openBook.api.BookingApi
import openBook.model.BookReserveResponse
import org.example.ports.`in`.BookReserveUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BookingController(
    private val reservationService: BookReserveUseCase
) : BookingApi {
    override suspend fun v1ReservePost(body: UUID): ResponseEntity<BookReserveResponse> {
        val reservation = reservationService.bookReserve(body)
        return ResponseEntity.ok().body(reservation)
    }
}