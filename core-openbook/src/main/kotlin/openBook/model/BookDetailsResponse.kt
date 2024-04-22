package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 * @param id 
 * @param name name of a book
 * @param authorId foreign key to a book's author
 * @param publicationId key to a book publication id
 * @param libraryId library this is in
 * @param description description of a book
 */
data class BookDetailsResponse(

    @get:JsonProperty("id") val id: java.util.UUID? = null,

    @get:JsonProperty("name") val name: kotlin.String? = null,

    @get:JsonProperty("authorId") val authorId: java.util.UUID? = null,

    @get:JsonProperty("publicationId") val publicationId: java.util.UUID? = null,

    @get:JsonProperty("libraryId") val libraryId: java.util.UUID? = null,

    @get:JsonProperty("description") val description: kotlin.String? = null
) {

}

