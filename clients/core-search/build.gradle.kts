plugins {
    id("org.openapi.generator") version "7.3.0"
}
val currentDirectory = "$rootDir/clients/core-search"
val outputDirectory: String = project(":libs:core-search").projectDir.path
configurations {
    // Define a configuration for OpenAPI generation excluding test dependencies
    val openApiGeneration by configurations.creating {
        exclude(group = "org.junit.jupiter", module = "junit-jupiter-api") // Example exclusion
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-test") // Example exclusion
        // Add more exclusions as needed for your project
    }
}
openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$currentDirectory/spec/api.yaml")
    configOptions.putAll(
        mapOf(
            "useSpringBoot3" to "true",
            "exceptionHandler" to "false",
            "useSwaggerUI" to "false",
            "documentationProvider" to "none",
            "basePackage" to "openBook",
            "apiPackage" to "openBook.api",
            "modelPackage" to "openBook.model",
            "apiSuffix" to "Api",
            "skipGeneratePom" to "true",
            "artifactId" to "core-openBook",
            "useBeanValidation" to "false",
            "interfaceOnly" to "true",
            "skipDefaultInterface" to "true",
            "useTags" to "true",
            "skipDefaultInterface" to "true",
            "reactive" to "true"
        )
    )
    generateApiDocumentation.set(false)
    generateModelDocumentation.set(false)
    generateApiTests.set(false)
    generateModelTests.set(false)
    outputDir.set(outputDirectory)
}

tasks.openApiGenerate {
    doFirst {
        delete(
            "$outputDirectory/src/main/kotlin/openBook/api",
            "$outputDirectory/src/main/kotlin/openBook/model",
            "$outputDirectory/spec/merged.yaml"
        )
    }
    doLast {
        delete(
            "$outputDirectory/.openapi-generator",
            "$outputDirectory/pom.xml",
            "$outputDirectory/README.md",
            "$outputDirectory/src/main/kotlin/openBook/api/ApiUtil.kt",
        )
        val buildScriptFile = File(outputDirectory, "build.gradle.kts")
        if (buildScriptFile.exists()) {
            val content = buildScriptFile.readText()
            val modifiedContent = content.replace("testImplementation`", "testImplementation")
            buildScriptFile.writeText(modifiedContent)
        }
    }
}
