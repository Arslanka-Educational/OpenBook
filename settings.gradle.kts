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
include("libs")
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
include("services")
include("services:core-catalog")
findProject(":services:core-catalog")?.name = "core-catalog"
include("services:core-search")
findProject(":services:core-search")?.name = "core-search"
include("services:core-client")
findProject(":services:core-client")?.name = "core-client"
include("services:core-booking")
findProject(":services:core-booking")?.name = "core-booking"
include("clients:api-gateway")
findProject(":clients:api-gateway")?.name = "api-gateway"
include("libs:api-gateway")
findProject(":libs:api-gateway")?.name = "api-gateway"
