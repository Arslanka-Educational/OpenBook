plugins {
    id("org.openapi.generator") version "7.1.0"
}
val currentDirectory = "$rootDir/clients/core-openbook"
val outputDirectory: String = project(":libs:core-openbook").projectDir.path

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
            "skipDefaultInterface" to "true"
        )
    )
    generateApiDocumentation.set(false)
    generateModelDocumentation.set(false)
    generateApiTests.set(false)
    outputDir.set(outputDirectory)
}

tasks.openApiGenerate {
    doFirst {
        delete(
            "$outputDirectory/src/main/kotlin/openBook/api",
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
    }
}
