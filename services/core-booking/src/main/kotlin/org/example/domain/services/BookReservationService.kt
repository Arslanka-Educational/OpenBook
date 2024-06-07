package org.example.domain.services

import openBook.model.Book
import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReserveResponse
import openBook.model.BookStatus
import org.example.adapter.CoreCatalogWriterAdapter
import org.example.exception.BookNotFoundException
import org.example.ports.`in`.BookReservationUseCase
import org.example.ports.out.storage.ReservationRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*

@Service
class BookReservationService(
    private val reservationRepository: ReservationRepository,
    private val coreCatalogWriterAdapter: CoreCatalogWriterAdapter,
) : BookReservationUseCase {

    @Value("\${application.reservation.reservation_time}")
    private val reservationTime: Long = 864000
    override suspend fun getReservationDetails(bookId: UUID): BookReservationDetailsResponse {
        return reservationRepository.getReservationInfo(bookId)
            ?: throw BookNotFoundException("Book with id: $bookId not found")
    }

    @Transactional
    override suspend fun reserveBook(bookId: UUID): BookReserveResponse {
        val book = Book(
            id = bookId,
            status = BookStatus.uNAVAILABLE
        )
        val reservedDate = Instant.now()
        val reservedDueDate = reservedDate.plusSeconds(reservationTime)

        coreCatalogWriterAdapter.updateBook(book)
        reservationRepository.reserveBook(
            book = book,
            reservationDate = reservedDate to reservedDueDate
        )

        return BookReserveResponse(
            reservedDate = OffsetDateTime.ofInstant(reservedDate, ZoneOffset.UTC),
            reservationExpirationDate = OffsetDateTime.ofInstant(reservedDueDate, ZoneOffset.UTC)
        )
    }

    override suspend fun removeReservation(bookId: UUID): Boolean {
        TODO("Not yet implemented")
    }
}