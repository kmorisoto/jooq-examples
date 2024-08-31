plugins {
    kotlin("jvm")
    id("org.jooq.jooq-codegen-gradle") version "3.19.11"
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
