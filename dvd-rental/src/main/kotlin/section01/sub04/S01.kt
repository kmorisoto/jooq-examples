package org.example.section01.sub04

import org.example.DBCase
import org.example.db.tables.references.COLORS
import org.jooq.DSLContext

class S01 : DBCase() {
    // SELECT
    //  DISTINCT bcolor
    //FROM
    //  colors
    //ORDER BY
    //  bcolor;
    override fun sql(ctx: DSLContext) {
        ctx.selectDistinct(COLORS.BCOLOR)
            .from(COLORS)
            .orderBy(COLORS.BCOLOR.asc())
            .fetch()
            .also { println(it) }
    }
}
