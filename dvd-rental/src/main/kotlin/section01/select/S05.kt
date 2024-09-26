package org.example.section01.select

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext
import org.jooq.impl.DSL

class S05 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT NOW();
        ctx.select(DSL.now())
            .fetch()
            .forEach { println(it) }
    }
}
