package mobi.sevenwinds.app.author

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.`java-time`.datetime


object AuthorTable : IntIdTable("author") {
    val fullName = varchar("full_name", 128)
    val creationTime = datetime("creation_time")
}

class AuthorEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AuthorEntity>(AuthorTable)

    var fullName by AuthorTable.fullName
    var creationTime by AuthorTable.creationTime

    fun toResponse(): AuthorRecord {
        return AuthorRecord(fullName, creationTime)
    }
}