package org.example

import org.example.db.tables.daos.UsersDao
import org.example.db.tables.pojos.Users
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jooq.JooqTest
import org.springframework.context.annotation.Import
import kotlin.test.assertNotNull

@JooqTest
// Importしないと失敗する
@Import(UsersDao::class)
class UsersDaoWithJooqTest {

    @Autowired
    lateinit var usersDao: UsersDao

    @Test
    fun findOne() {
        val actual = usersDao.findById(1)

        assertNotNull(actual)
        assertEquals("admin", actual.username)
    }

    @Test
    fun count() {
        val actual = usersDao.count()

        assertEquals(2, actual)
    }

    @Test
    fun insert() {
        usersDao.insert(
            Users(100, "test", "test@example.com")
        )

        assertEquals(3, usersDao.count())
    }
}
