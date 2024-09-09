buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.flywaydb:flyway-database-postgresql:10.10.0")
    }
}

plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.jooq.jooq-codegen-gradle") version  "3.19.11"
    id("org.flywaydb.flyway") version "10.10.0"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.jooq:jooq-meta")
    implementation("org.jooq:jooq-codegen")
    implementation("org.jooq:jooq-postgres-extensions:${dependencyManagement.managedVersions["org.jooq:jooq"]}")
    jooqCodegen("org.postgresql:postgresql:${dependencyManagement.managedVersions["org.postgresql:postgresql"]}")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
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
