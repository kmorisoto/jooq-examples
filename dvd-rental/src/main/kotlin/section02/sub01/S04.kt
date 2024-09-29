package org.example.section02.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S04 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT
        //  first_name,
        //  last_name
        //FROM
        //  customer
        //WHERE
        //  first_name IN ('Ann', 'Anne', 'Annie');
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
            .from(CUSTOMER)
            .where(CUSTOMER.FIRST_NAME.`in`("Ann", "Anne", "Annie"))
            .fetch()
            .also { println(it) }
    }
}
