package org.example.adapters.out.r2dbc.util

import openBook.model.BookStatus

object BookStatusUtil {
    fun fromValue(value: String): BookStatus {
        return BookStatus.entries.find { it.value == value }
            ?: throw IllegalArgumentException("No enum constant for value: $value")
    }
}