package openbook.adapters.out

import openbook.ports.out.BookRepository
import org.springframework.stereotype.Repository

@Repository
class JdbcBookRepository : BookRepository {
}