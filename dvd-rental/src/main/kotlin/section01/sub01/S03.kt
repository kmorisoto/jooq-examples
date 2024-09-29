package org.example.section01.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S03 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT * FROM customer;
        ctx.selectFrom(CUSTOMER)
            .fetch()
            .also { println(it) }
    }
}
