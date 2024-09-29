package org.example

import org.jooq.CloseableDSLContext
import org.jooq.DSLContext
import org.jooq.exception.DataAccessException
import org.jooq.impl.DSL

abstract class DBCase {
    abstract fun sql(ctx: DSLContext)
    fun run() {
        try {
            DSL.using("jdbc:postgresql://localhost:5432/dvdrental", "postgres", "password")
                .use {
                    execute(it)
                }
        } catch (e: DataAccessException) {
            // do nothing
            when (e.cause) {
                is RollBack -> {}
                else -> throw e
            }
        }
    }

    private fun execute(it: CloseableDSLContext) {
        it.transaction { trx ->
            try {
                sql(trx.dsl())
            } finally {
                throw RollBack()
            }
        }
    }
}

class RollBack : Exception()
