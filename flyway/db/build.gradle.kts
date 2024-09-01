plugins {
    kotlin("jvm")
    id("org.jooq.jooq-codegen-gradle") version "3.19.11"
    id("org.flywaydb.flyway") version "9.22.3"
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.jooq:jooq:3.19.11")
    implementation("org.jooq:jooq-meta:3.19.11")
    implementation("org.jooq:jooq-codegen:3.19.11")
    implementation("org.jooq:jooq-postgres-extensions:3.19.11")

    runtimeOnly("org.postgresql:postgresql:42.7.4")
    jooqCodegen("org.postgresql:postgresql:42.7.4")
}

jooq {
    configuration {

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
                excludes = "flyway_schema_history"
            }

            target {
                packageName = "org.example.db"
            }
        }
    }
}

sourceSets.main {
    java.srcDirs("build/generated-sources/jooq")
}

// https://www.jooq.org/doc/latest/manual/code-generation/codegen-gradle/codegen-gradle-compiler-dependency/
tasks.named("compileKotlin") {
    dependsOn(tasks.named("jooqCodegen"))
}

flyway {
    driver = "org.postgresql.Driver"
    url = "jdbc:postgresql://localhost:5432/postgres"
    user = "postgres"
    password = "password"
    schemas = arrayOf("public")
    cleanDisabled = false
}

tasks.named("jooqCodegen") {

    // Run code generation after Flyway migration
    dependsOn(tasks.named("flywayMigrate"))

    // Optional: Use Flyway migration scripts as input to code generation, to avoid
    // task execution when unnecessary
    inputs.files(fileTree("src/main/resources/db/migration"))
}
