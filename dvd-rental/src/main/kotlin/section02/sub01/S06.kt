package org.example.section02.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext
import org.jooq.impl.DSL

class S06 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT
        //  first_name,
        //  LENGTH(first_name) name_length
        //FROM
        //  customer
        //WHERE
        //  first_name LIKE 'A%'
        //  AND LENGTH(first_name) BETWEEN 3
        //  AND 5
        //ORDER BY
        //  name_length;
        ctx.select(CUSTOMER.FIRST_NAME, DSL.length(CUSTOMER.FIRST_NAME).`as`("name_length"))
            .from(CUSTOMER)
            .where(CUSTOMER.FIRST_NAME.like("A%"))
            .and(DSL.length(CUSTOMER.FIRST_NAME).between(3).and(5))
            .fetch()
            .also { println(it) }
    }
}
