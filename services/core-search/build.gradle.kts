import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.spring") version "1.9.22"
}

group = "org.example"
version = "unspecified"
project.archivesName = "core-search"

tasks.bootJar {
    archiveClassifier = ""
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":libs:core-search"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.postgresql:r2dbc-postgresql")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("ch.qos.logback:logback-classic") // Logback implementation
    implementation("org.slf4j:slf4j-api") // SLF4J API
}

kotlin {
    jvmToolchain(17)
}