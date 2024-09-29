package org.example.section02.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext

class S07 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT
        //  first_name,
        //  last_name
        //FROM
        //  customer
        //WHERE
        //  first_name LIKE 'Bra%'
        //  AND last_name <> 'Motley';
        ctx.select(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
            .from(CUSTOMER)
            .where(CUSTOMER.FIRST_NAME.like("Bra%"))
            .and(CUSTOMER.LAST_NAME.notEqual("Motley"))
            .fetch()
            .also { println(it) }
    }
}
