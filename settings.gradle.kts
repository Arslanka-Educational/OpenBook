pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/snapshot") }
        maven { url = uri("https://repo.spring.io/milestone") }
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") {
                useModule("org.springframework.boot:spring-boot-gradle-plugin:${requested.version}")
            }
        }
    }
}

rootProject.name = "OpenBook"
include("clients:core-client")
findProject(":clients:core-client")?.name = "core-client"
include("clients:core-catalog")
findProject(":clients:core-catalog")?.name = "core-catalog"
include("clients:core-search")
findProject(":clients:core-search")?.name = "core-search"
include("clients:core-booking")
findProject(":clients:core-booking")?.name = "core-booking"
include("libs:core-catalog")
findProject(":libs:core-catalog")?.name = "core-catalog"
include("libs:core-client")
findProject(":libs:core-client")?.name = "core-client"
include("libs:core-search")
findProject(":libs:core-search")?.name = "core-search"
include("libs:core-booking")
findProject(":libs:core-booking")?.name = "core-booking"
//include("services")
include("services:core-catalog")
findProject(":services:core-catalog")?.name = "core-catalog"
include("services:core-search")
findProject(":services:core-search")?.name = "core-search"
include("services:core-client")
findProject(":services:core-client")?.name = "core-client"
include("services:core-booking")
findProject(":services:core-booking")?.name = "core-booking"
include("clients:core-gateway")
findProject(":clients:core-gateway")?.name = "core-gateway"
include("libs:core-gateway")
findProject(":libs:core-gateway")?.name = "core-gateway"
include("libs:core-catalog-writer")
findProject(":libs:core-catalog-writer")?.name = "core-catalog-writer"
include("clients:core-catalog-writer")
findProject(":clients:core-catalog-writer")?.name = "core-catalog-writer"
include("services:core-catalog-writer")
findProject(":services:core-catalog-writer")?.name = "core-catalog-writer"
include("services:core-gateway")
findProject(":services:core-gateway")?.name = "core-gateway"
include("services:adapters")
findProject(":services:adapters")?.name = "adapters"
include("services:adapters:core-search")
findProject(":services:adapters:core-search")?.name = "core-search"
include("services:adapters:core-catalog-writer")
findProject(":services:adapters:core-catalog-writer")?.name = "core-catalog-writer"
include("services:adapters:core-booking")
findProject(":services:adapters:core-booking")?.name = "core-booking"
include("services:adapters:core-catalog")
findProject(":services:adapters:core-catalog")?.name = "core-catalog"
