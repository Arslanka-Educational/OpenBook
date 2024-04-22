plugins {
    kotlin("jvm") version "1.9.21"
    application
    id("org.openapi.generator") version "7.1.0"
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("plugin.spring") version "1.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/client/spec/api.yaml")
    configOptions.putAll(
        mapOf(
            Pair("useSpringBoot3", "true"),
            Pair("exceptionHandler", "false"),
            Pair("useSwaggerUI", "false"),
            Pair("documentationProvider", "none"),
            Pair("gradleBuildFile", "false"),
            Pair("basePackage", "openBook"),
            Pair("apiPackage", "openBook.api"),
            Pair("modelPackage", "openBook.model"),
            Pair("apiSuffix", "CoreOpenBookApi"),
            Pair("skipGeneratePom", "true"),
            Pair("artifactId", "core-openBook"),
            Pair("useBeanValidation", "false"),
            Pair("interfaceOnly", "true"),
            Pair("skipDefaultInterface", "true"),
        )
    )
    generateApiDocumentation.set(false)
    generateModelDocumentation.set(false)
    generateApiTests.set(false)
    outputDir.set("$rootDir/client")
}

tasks.openApiGenerate {
    doFirst {
        delete (
            "$rootDir/client/src/main/kotlin/openBook/api",
            "$rootDir/client/spec/merged.yaml"
        )
    }
    doLast {
        delete (
            "$rootDir/client/.openapi-generator",
            "$rootDir/client/pom.xml",
            "$rootDir/client/README.md",
            "$rootDir/client/src/main/kotlin/openBook/api/ApiUtil.kt"
        )
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("org.springdoc:springdoc-openapi-core:1.1.16")
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileKotlin {
    dependsOn("openApiGenerate")
}

tasks.processResources {
    dependsOn("openApiGenerate")
}

application {
    mainClass.set("Main.kt")
}