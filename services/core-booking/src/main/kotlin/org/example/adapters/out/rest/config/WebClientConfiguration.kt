package org.example.adapters.out.rest.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfiguration {
    @Value("\${external.core-catalog-writer.address}")
    lateinit var coreCatalogWriterUrl: String

    @Bean
    fun coreCatalogWriterWebClient(): WebClient = WebClient.builder().baseUrl(coreCatalogWriterUrl).build()

}