plugins {
    kotlin("jvm") version "1.9.21"
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.spring") version "1.9.22"
}

group = "org.example"
version = "unspecified"

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

tasks.bootJar {
    enabled = false
}
tasks.jar {
    archiveClassifier = ""
}

dependencies {
    implementation(project(":libs:core-catalog"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
}