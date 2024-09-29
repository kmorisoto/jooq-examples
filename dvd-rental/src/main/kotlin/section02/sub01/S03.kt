package org.example.section02.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S03 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT
        //  first_name,
        //  last_name
        //FROM
        //  customer
        //WHERE
        //  last_name = 'Rodriguez'
        //  OR first_name = 'Adam';
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
            .from(CUSTOMER)
            .where(CUSTOMER.LAST_NAME.eq("Rodriguez"))
            .or(CUSTOMER.FIRST_NAME.eq("Adam"))
            .fetch()
            .also { println(it) }
    }
}
