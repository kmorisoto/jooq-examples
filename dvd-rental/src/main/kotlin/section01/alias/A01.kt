package org.example.section01.alias

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class A01 : DBCase() {
    // SELECT
    //   first_name,
    //   last_name surname
    //FROM customer;
    override fun sql(ctx: DSLContext) {
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME.`as`("surname"))
            .from(CUSTOMER)
            .fetch()
            .forEach { println(it) }
    }
}
