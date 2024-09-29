package org.example.section02.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S01 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT
        //  last_name,
        //  first_name
        //FROM
        //  customer
        //WHERE
        //  first_name = 'Jamie';
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
            .from(CUSTOMER)
            .where(CUSTOMER.FIRST_NAME.eq("Jamie"))
            .fetch()
            .also { println(it) }
    }
}
