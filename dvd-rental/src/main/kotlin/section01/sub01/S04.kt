package org.example.section01.sub01

import org.example.DBCase
import org.example.db.tables.references.CUSTOMER
import org.jooq.DSLContext
import org.jooq.impl.DSL

class S04 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT
        //   first_name || ' ' || last_name,
        //   email
        //FROM
        //   customer;
//        ctx.select(DSL.concat(CUSTOMER.FIRST_NAME, DSL.inline(" "), CUSTOMER.LAST_NAME), CUSTOMER.EMAIL)
        ctx.select(DSL.concat(CUSTOMER.FIRST_NAME, DSL.`val`(" "), CUSTOMER.LAST_NAME), CUSTOMER.EMAIL)
//        ctx.select(CUSTOMER.FIRST_NAME.concat(DSL.inline(" ")).concat(CUSTOMER.LAST_NAME), CUSTOMER.EMAIL)
            .from(CUSTOMER)
            .fetch()
            .forEach { println(it) }
    }
}
