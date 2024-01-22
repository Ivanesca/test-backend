package mobi.sevenwinds.app.author

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime

object AuthorService {
    suspend fun addAuthor(authorParam: AuthorParam): AuthorRecord = withContext(Dispatchers.IO) {
        transaction {
            val entity = AuthorEntity.new {
                this.fullName = authorParam.fullName
                this.creationTime = LocalDateTime.now()
            }

            return@transaction entity.toResponse()
        }
    }
}