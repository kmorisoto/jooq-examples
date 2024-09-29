package org.example.section01.sub04

import org.example.DBCase
import org.example.db.tables.references.FILM
import org.jooq.DSLContext

class S03 : DBCase() {
    // SELECT DISTINCT
    //  rental_rate
    //FROM
    //  film
    //ORDER BY
    //  rental_rate;
    override fun sql(ctx: DSLContext) {
        ctx.selectDistinct(FILM.RENTAL_RATE)
            .from(FILM)
            .orderBy(FILM.RENTAL_RATE.asc())
            .fetch()
            .forEach { println(it) }
    }
}
