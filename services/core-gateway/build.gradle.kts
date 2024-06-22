import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.spring") version "1.9.22"
}

project.archivesName = "core-gateway"

kotlin {
    jvmToolchain(17)
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

tasks.bootJar {
    archiveClassifier = ""
}

dependencies {
    implementation(project(":libs:core-gateway"))
    implementation(project(":services:adapters:core-booking"))
    implementation(project(":services:adapters:core-catalog"))
    implementation(project(":services:adapters:core-catalog-writer"))
    implementation(project(":services:adapters:core-search"))

    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.postgresql:r2dbc-postgresql")
//    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation(project(mapOf("path" to ":libs:core-catalog-writer")))
}