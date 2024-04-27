package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id 
 * @param name name of a book
 * @param authorId foreign key to a book's author
 * @param publisherId key to a book publication id
 * @param libraryId library this is in
 */
data class BookDetailsResponse(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("name", required = true) val name: kotlin.String,

    @get:JsonProperty("authorId", required = true) val authorId: java.util.UUID,

    @get:JsonProperty("publisherId", required = true) val publisherId: java.util.UUID,

    @get:JsonProperty("libraryId", required = true) val libraryId: java.util.UUID
) {

}

