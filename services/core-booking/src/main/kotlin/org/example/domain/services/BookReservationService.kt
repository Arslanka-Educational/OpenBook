package org.example.domain.services

import openBook.model.BookReservationDetailsResponse
import openBook.model.BookReserveResponse
import openBook.model.BookStatus
import org.example.exception.BookNotFoundException
import org.example.ports.`in`.BookReservationUseCase
import org.example.ports.out.storage.BookDetailsRepository
import org.example.ports.out.storage.BookingRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*

@Service
class BookReservationService(
    private val bookingRepository: BookingRepository,
    private val bookDetailsRepository: BookDetailsRepository,
) : BookReservationUseCase {

    @Value("\${application.reservation.reservation_time}")
    private val reservationTime: Long = 864000

    override suspend fun getReservationDetails(bookId: UUID): BookReservationDetailsResponse {
        return bookingRepository.getReservationInfo(bookId)
            ?: throw BookNotFoundException("Book with id: $bookId not found")
    }

    @Transactional(transactionManager = "jtaTransactionManager", rollbackFor = [Exception::class])
    override suspend fun reserveBook(bookId: UUID): BookReserveResponse {
        val book = bookDetailsRepository.getBookDetails(bookId)?.copy(
            status = BookStatus.uNAVAILABLE
        ) ?: throw BookNotFoundException("Book with id $bookId not found")

        val reservedDate = Instant.now()
        val reservedDueDate = reservedDate.plusSeconds(reservationTime)

        bookDetailsRepository.updateBook(book)
        bookingRepository.reserveBook( //todo: check if everything is updated
            book = book,
            reservationDate = reservedDate to reservedDueDate
        )
        throw Exception()

        return BookReserveResponse(
            reservedDate = OffsetDateTime.ofInstant(reservedDate, ZoneOffset.UTC),
            reservationExpirationDate = OffsetDateTime.ofInstant(reservedDueDate, ZoneOffset.UTC)
        )
    }

    override suspend fun removeReservation(bookId: UUID): Boolean {
        TODO("Not yet implemented")
    }
}