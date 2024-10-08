package org.example.section01.sub02

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext
import org.jooq.impl.DSL

class S03 : DBCase() {
    // SELECT
    //    first_name || ' ' || last_name AS full name
    //FROM
    //    customer;
    override fun sql(ctx: DSLContext) {
        ctx.select(DSL.concat(CUSTOMER.FIRST_NAME, DSL.`val`(" "), CUSTOMER.LAST_NAME).`as`("full name"))
            .from(CUSTOMER)
            .fetch()
            .also { println(it) }
    }
}
