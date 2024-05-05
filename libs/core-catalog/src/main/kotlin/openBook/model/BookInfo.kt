package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id 
 * @param name name of a book
 * @param authorId foreign key to a book's author
 */
data class BookInfo(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @get:JsonProperty("authorId", required = true) val authorId: java.util.UUID
) {

}

