plugins {
    kotlin("jvm") version "2.0.10"
    id("org.jooq.jooq-codegen-gradle") version "3.19.11"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jooq:jooq")
    implementation("org.jooq:jooq-meta")
    implementation("org.jooq:jooq-codegen")
    implementation("org.jooq:jooq-postgres-extensions")

    runtimeOnly("org.postgresql:postgresql:42.7.4")
    jooqCodegen("org.postgresql:postgresql:42.7.4")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}


jooq {
    configuration {

        // Configure the database connection here
        jdbc {
            driver = "org.postgresql.Driver"
            url = "jdbc:postgresql://localhost:5432/postgres"
            user = "postgres"
            password = "password"
        }
        generator {
            database {
                name = "org.jooq.meta.postgres.PostgresDatabase"
                inputSchema = "public"
                includes = ".*"
            }

            target {
                packageName = "org.example.db"
                directory = "build/generated-src/jooq/main"
            }
        }
    }
}
