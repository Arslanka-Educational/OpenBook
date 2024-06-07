import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.spring") version "1.9.22"
}

project.archivesName = "core-booking"

tasks.bootJar {
    archiveClassifier = ""
}

kotlin {
    jvmToolchain(17)
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":libs:core-booking"))
    implementation(project(":libs:core-search"))
    implementation(project(":services:adapters::core-catalog-writer"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    implementation("com.atomikos:transactions-spring-boot3-starter:6.0.0")
    implementation("javax.transaction:jta:1.1")

    runtimeOnly("org.postgresql:postgresql")

    implementation("net.javacrumbs.shedlock:shedlock-provider-jdbc-template:5.10.0")
}