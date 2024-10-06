package org.example.section02.sub02

import org.example.DBCase
import org.jooq.DSLContext
import org.jooq.impl.DSL

class S01 : DBCase() {
    override fun sql(ctx: DSLContext) {
        // SELECT true AND true AS result;
        ctx.select(DSL.and(DSL.trueCondition(), DSL.trueCondition()).`as`("result"))
            .fetch()
            .also { println(it) }

        // SELECT true AND false AS result;
        ctx.select(DSL.and(DSL.trueCondition(), DSL.falseCondition()).`as`("result"))
            .fetch()
            .also { println(it) }

        // SELECT true AND null AS result;
        ctx.select(DSL.and(DSL.trueCondition(), DSL.nullCondition()).`as`("result"))
            .fetch()
            .also { println(it) }

        // SELECT false AND false AS result;
        ctx.select(DSL.and(DSL.falseCondition(), DSL.falseCondition()).`as`("result"))
            .fetch()
            .also { println(it) }

        // SELECT false AND null AS result;
        ctx.select(DSL.and(DSL.falseCondition(), DSL.nullCondition()).`as`("result"))
            .fetch()
            .also { println(it) }

        // SELECT null and null AS result;
        ctx.select(DSL.and(DSL.nullCondition(), DSL.nullCondition()).`as`("result"))
            .fetch()
            .also { println(it) }

    }
}
