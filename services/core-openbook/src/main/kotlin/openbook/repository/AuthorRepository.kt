package openbook.repository

import openBook.model.AuthorDetailsResponse
import openbook.model.Author
import org.springframework.dao.DataAccessException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class AuthorRepository(
    val jdbcTemplate: NamedParameterJdbcTemplate
) {
    fun getAuthorDetails(authorId: UUID): AuthorDetailsResponse? =
        try {
            jdbcTemplate.queryForObject(
                GET_BY_ID,
                MapSqlParameterSource()
                    .addValue("id", authorId)
            ) { r, _ ->
                AuthorDetailsResponse(
                    UUID.fromString(r.getString("id")),
                    r.getString("name")
                )
            }
        } catch (e: EmptyResultDataAccessException) {
            null
        }


    companion object {
        private const val GET_BY_ID = """
            SELECT * from authors WHERE id=:id
        """
    }
}