package org.example.section01.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S02 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT
        //   first_name,
        //   last_name,
        //   email
        // FROM
        //   customer;
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME, CUSTOMER.EMAIL)
            .from(CUSTOMER)
            .fetch()
            .forEach { println(it) }
    }
}
