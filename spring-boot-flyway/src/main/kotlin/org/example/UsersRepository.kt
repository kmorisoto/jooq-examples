package org.example

import org.example.db.Tables
import org.example.db.tables.pojos.Users
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UsersRepository(
    private val dsl: DSLContext
) {
    fun findAll(): List<Users> = dsl.selectFrom(Tables.USERS).fetchInto(Users::class.java)

    fun save(username: String, email: String) = dsl.insertInto(Tables.USERS)
        .set(Tables.USERS.USERNAME, username)
        .set(Tables.USERS.EMAIL, email)
        .execute()
}
