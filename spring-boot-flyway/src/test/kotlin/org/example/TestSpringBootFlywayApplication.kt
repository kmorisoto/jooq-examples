package org.example

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<SpringBootFlywayApplication>().with(TestcontainersConfiguration::class).run(*args)
}
