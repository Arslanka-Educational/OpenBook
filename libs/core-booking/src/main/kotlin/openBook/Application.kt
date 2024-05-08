package openBook

import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
@ComponentScan(basePackages = ["openBook", "openBook.api", "openBook.model"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
