package org.example.api.config

import org.example.CoreCatalogAdapter
import org.example.CoreCatalogAdapterService
import org.example.adapter.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdapterConfiguration {
    @Bean
    fun coreCatalogClient(@Value("\${external.core-catalog.url}") coreCatalogUrl: String): CoreCatalogAdapter =
        CoreCatalogAdapterService(coreCatalogUrl)

    @Bean
    fun coreBookingClient(@Value("\${external.core-booking.url}") coreBookingUrl: String): CoreBookingAdapter =
        CoreBookingAdapterService(coreBookingUrl)

    @Bean
    fun coreCatalogWriterClient(@Value("\${external.core-catalog-writer.url}") coreCatalogWriterUrl: String): CoreCatalogWriterAdapter =
        CoreCatalogWriterAdapterService(coreCatalogWriterUrl)

    @Bean
    fun coreSearchClient(@Value("\${external.core-search.url}") coreSearchUrl: String): CoreSearchAdapter =
        CoreSearchAdapterService(coreSearchUrl)
}