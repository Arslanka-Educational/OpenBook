package org.example.adapter

import kotlinx.coroutines.runBlocking
import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReserveResponse
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

class CoreBookingAdapterService(
    private val coreBookingUrl: String,
    private val restTemplate: RestTemplate = RestTemplate(),
) : CoreBookingAdapter {
    override suspend fun v1ReserveBook(bookId: UUID): BookReserveResponse = runBlocking {
        val uri = createBuilder("/v1/reserve")
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val request = HttpEntity(mapOf("book_id" to bookId), headers)
        return@runBlocking restTemplate.postForObject(
            uri.toUriString(),
            request,
            BookReserveResponse::class.java
        ) as BookReserveResponse
    }

    override suspend fun v1GetReservation(bookId: UUID): BookReservationDetailsResponse = runBlocking {
        val uri = createBuilder("/v1/reservation/$bookId")
        return@runBlocking restTemplate.getForObject(
            uri.toUriString(),
            BookReservationDetailsResponse::class.java
        ) as BookReservationDetailsResponse
    }

    private fun createBuilder(method: String): UriComponentsBuilder {
        return UriComponentsBuilder.fromHttpUrl(coreBookingUrl).path(method)
    }
}