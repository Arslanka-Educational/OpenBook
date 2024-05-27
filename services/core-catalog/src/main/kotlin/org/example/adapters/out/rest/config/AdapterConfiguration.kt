package org.example.adapters.out.rest.config

import org.example.adapter.CoreSearchAdapter
import org.example.adapter.CoreSearchAdapterService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdapterConfiguration {
    @Bean
    fun coreSearchClient(@Value("\${external.core-search.url}") coreSearchUrl: String): CoreSearchAdapter =
        CoreSearchAdapterService(coreSearchUrl)
}