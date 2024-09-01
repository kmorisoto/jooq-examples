package org.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootFlywayApplication

fun main(args: Array<String>) {
    runApplication<SpringBootFlywayApplication>(*args)
}
