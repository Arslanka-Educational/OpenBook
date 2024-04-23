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
            Pair("useSpringBoot3", "true"),
            Pair("exceptionHandler", "false"),
            Pair("useSwaggerUI", "false"),
            Pair("documentationProvider", "none"),
            Pair("basePackage", "openBook"),
            Pair("apiPackage", "openBook.api"),
            Pair("modelPackage", "openBook.model"),
            Pair("apiSuffix", "Api"),
            Pair("skipGeneratePom", "true"),
            Pair("artifactId", "core-openBook"),
            Pair("useBeanValidation", "false"),
            Pair("interfaceOnly", "true"),
            Pair("skipDefaultInterface", "true"),
            Pair("useTags", "true"),
            Pair("skipDefaultInterface", "true"),
        )
    )
    generateApiDocumentation.set(false)
    generateModelDocumentation.set(false)
    generateApiTests.set(false)
    outputDir.set(outputDirectory)
}

tasks.openApiGenerate {
    doFirst {
        delete (
            "$outputDirectory/src/main/kotlin/openBook/api",
            "$outputDirectory/spec/merged.yaml"
        )
    }
    doLast {
        delete (
            "$outputDirectory/.openapi-generator",
            "$outputDirectory/pom.xml",
            "$outputDirectory/README.md",
            "$outputDirectory/src/main/kotlin/openBook/api/ApiUtil.kt"
        )
    }
}
