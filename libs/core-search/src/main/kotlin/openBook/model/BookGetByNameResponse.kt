package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import openBook.model.BookInfo

/**
 * 
 * @param booksInfo 
 */
data class BookGetByNameResponse(

    @get:JsonProperty("books_info") val booksInfo: kotlin.collections.List<BookInfo>? = null
) {

}

