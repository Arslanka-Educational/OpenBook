package openBook.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import openBook.model.BookInfoCreateDetails

/**
 * 
 * @param libraryId 
 * @param booksList 
 */
data class InsertBookIntoLibraryRequest(

    @get:JsonProperty("library_id", required = true) val libraryId: java.util.UUID,

    @get:JsonProperty("books_list", required = true) val booksList: kotlin.collections.List<BookInfoCreateDetails>
) {

}

