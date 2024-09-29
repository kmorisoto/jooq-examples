package org.example.section01.sub03

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext
import org.jooq.impl.DSL

class S04 : DBCase() {
    // SELECT
    //  first_name,
    //  LENGTH(first_name) len
    //FROM
    //  customer
    //ORDER BY
    //  len DESC;
    override fun sql(ctx: DSLContext) {
        ctx.select(CUSTOMER.FIRST_NAME, DSL.length(CUSTOMER.FIRST_NAME).`as`("len"))
            .from(CUSTOMER)
            .orderBy(DSL.field("len").desc())
            .fetch()
            .also { println(it) }
    }
}
