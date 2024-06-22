package org.example.adapter

import kotlinx.coroutines.runBlocking
import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReserveResponse
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

class CoreBookingAdapterService(
    private val coreBookingUrl: String,
    private val restTemplate: RestTemplate = RestTemplate(),
) : CoreBookingAdapter {
    override suspend fun v1ReserveBook(bookId: UUID): ResponseEntity<BookReserveResponse> = runBlocking {
        val uri = createBuilder("/v1/reserve")
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val request = HttpEntity(mapOf("book_id" to bookId), headers)

        return@runBlocking restTemplate.postForEntity(
            uri.toUriString(),
            request,
            BookReserveResponse::class.java
        )
    }

    override suspend fun v1GetReservation(bookId: UUID): ResponseEntity<BookReservationDetailsResponse> = runBlocking {
        val uri = createBuilder("/v1/reservation/$bookId")

        return@runBlocking restTemplate.getForEntity(
            uri.toUriString(),
            BookReservationDetailsResponse::class.java
        )
    }

    private fun createBuilder(method: String): UriComponentsBuilder {
        return UriComponentsBuilder.fromHttpUrl(coreBookingUrl).path(method)
    }
}