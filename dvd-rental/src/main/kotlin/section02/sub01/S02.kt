package org.example.section02.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S02 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT
        //  last_name,
        //  first_name
        //FROM
        //  customer
        //WHERE
        //  first_name = 'Jamie'
        //  AND last_name = 'Rice';
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
            .from(CUSTOMER)
            .where(CUSTOMER.FIRST_NAME.eq("Jamie"))
            .and(CUSTOMER.LAST_NAME.eq("Rice"))
            .fetch()
            .also { println(it) }
    }
}
