package org.example.section01.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S01 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT first_name FROM customer;
        ctx.select(CUSTOMER.FIRST_NAME)
            .from(CUSTOMER)
            .fetch()
            .also { println(it) }
    }
}
