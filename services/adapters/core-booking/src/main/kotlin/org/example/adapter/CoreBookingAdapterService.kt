package org.example.adapter

import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReserveResponse
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import java.util.*

class CoreBookingAdapterService(
    private val coreBookingUrl: String,
    private val coreBookingWebClient: WebClient = WebClient.builder().baseUrl(coreBookingUrl).build(),
) : CoreBookingAdapter {
    override suspend fun v1ReserveBook(bookId: UUID): BookReserveResponse = coreBookingWebClient
        .post()
        .uri("/v1/reserve")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(mapOf("book_id" to bookId))
        .retrieve()
        .awaitBody<BookReserveResponse>()

    override suspend fun v1GetReservation(bookId: UUID): BookReservationDetailsResponse = coreBookingWebClient
        .get()
        .uri("/v1/reservation/$bookId")
        .retrieve()
        .awaitBody<BookReservationDetailsResponse>()
}