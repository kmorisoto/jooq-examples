plugins {
    kotlin("jvm") version "2.0.20"
    id("org.jooq.jooq-codegen-gradle") version "3.19.11"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jooq:jooq:3.19.11")
    implementation("org.jooq:jooq-meta:3.19.11")
    implementation("org.jooq:jooq-codegen:3.19.11")
    implementation("org.jooq:jooq-postgres-extensions:3.19.11")

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

// https://www.jooq.org/doc/latest/manual/code-generation/codegen-gradle/codegen-gradle-compiler-dependency/
tasks.named("compileKotlin") {
    dependsOn(tasks.named("jooqCodegen"))
}
