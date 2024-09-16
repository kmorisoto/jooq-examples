package org.example

import org.jooq.DSLContext
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jooq.JooqTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.jdbc.Sql
import kotlin.test.assertEquals

@JooqTest
@Import(TestcontainersConfiguration::class)
@Sql("/test-data.sql")
class UsersRepositoryTest {

    @Autowired
    lateinit var dsl: DSLContext

    lateinit var usersRepository: UsersRepository

    @BeforeEach
    fun setup() {
        usersRepository = UsersRepository(dsl)
    }

    @Test
    fun findAll() {
        val actual = usersRepository.findAll()
        assertEquals(2, actual.size)
    }

    @ParameterizedTest
    @CsvSource(
        "a, a@example.com", "b, b@example.com", "c, c@example.com"
    )
    fun save(name: String, email: String) {
        usersRepository.save(name, email)
    }

}
