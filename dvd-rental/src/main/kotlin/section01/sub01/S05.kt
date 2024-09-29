package org.example.section01.sub01

import org.example.DBCase
import org.jooq.DSLContext
import org.jooq.impl.DSL

class S05 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT NOW();
        ctx.select(DSL.now())
            .fetch()
            .also { println(it) }
    }
}
