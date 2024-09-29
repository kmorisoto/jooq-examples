package org.example.section01.sub03

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S02 : DBCase() {
    // SELECT
    //  first_name,
    //  last_name
    //FROM
    //  customer
    //ORDER BY
    //  last_name DESC;
    override fun sql(ctx: DSLContext) {
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
            .from(CUSTOMER)
            .orderBy(CUSTOMER.LAST_NAME.desc())
            .fetch()
            .also { println(it) }
    }
}
