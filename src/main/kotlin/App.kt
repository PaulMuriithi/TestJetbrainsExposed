import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    Database.connect(
            url = "jdbc:mysql://localhost:3306/somedb?useSSL=false",
            driver = "com.mysql.jdbc.Driver",
            user = "someuser",
            password = "somepassword")
    transaction {
        logger.addLogger(StdOutSqlLogger)
        SchemaUtils.create(Users)
    }
}

object Users : IntIdTable() {
    val name = varchar("name", length = 60)
}