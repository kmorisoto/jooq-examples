package org.example

import org.jooq.DSLContext
import org.jooq.impl.DSL

abstract class DBCase {
    abstract fun sql(ctx: DSLContext)
    fun run() {
        DSL.using("jdbc:postgresql://localhost:5432/dvdrental", "postgres", "password")
            .use { sql(it) }
    }
}
