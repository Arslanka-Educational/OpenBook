package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import openBook.model.Book

/**
 * 
 * @param bookInfoId 
 * @param books 
 */
data class BookGetByInfoIdResponse(

    @get:JsonProperty("bookInfoId", required = true) val bookInfoId: java.util.UUID,

    @get:JsonProperty("books", required = true) val books: kotlin.collections.List<Book> = arrayListOf()
) {

}

