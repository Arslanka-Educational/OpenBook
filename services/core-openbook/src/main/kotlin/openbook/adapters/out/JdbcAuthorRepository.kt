package openbook.adapters.out

import openbook.ports.out.AuthorRepository
import org.springframework.stereotype.Repository

@Repository
class JdbcAuthorRepository : AuthorRepository {
}