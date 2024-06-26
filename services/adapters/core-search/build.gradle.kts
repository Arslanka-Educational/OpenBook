plugins {
    kotlin("jvm") version "1.9.21"
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.spring") version "1.9.22"
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
    implementation(project(":libs:core-search"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
}

tasks.bootJar {
    enabled = false
}
tasks.jar {
    archiveClassifier = ""
}