package org.example.adapters.out.storage.jdbc.config.datasource

import com.atomikos.jdbc.AtomikosDataSourceBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class CoreCatalogDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.jdbc.core-catalog")
    fun coreCatalogDataSourceProperties(): DataSourceProperties = DataSourceProperties();

    @Bean
    fun coreCatalogDataSource(): DataSource = coreCatalogDataSourceProperties()
        .initializeDataSourceBuilder()
        .build()

    @Bean
    fun coreCatalogAtomikosDataSource(
        @Value("\${spring.datasource.jdbc.core-catalog.xa.properties.username}") user: String,
        @Value("\${spring.datasource.jdbc.core-catalog.xa.properties.password}") password: String,
        @Value("\${spring.datasource.jdbc.core-catalog.xa.properties.url}") url: String,
        @Value("\${spring.datasource.jdbc.core-catalog.xa.data-source-class-name}") dscn: String
    ) = AtomikosDataSourceBean().also {
        it.uniqueResourceName = "coreCatalog"
        it.xaDataSourceClassName = dscn
        it.xaProperties["user"] = user
        it.xaProperties["password"] = password
        it.xaProperties["url"] = url
        it.maxPoolSize = 100
    }

    @Bean
    fun coreCatalogJdbcTemplate(@Qualifier("coreCatalogAtomikosDataSource") coreCatalogDataSource: DataSource) =
        NamedParameterJdbcTemplate(coreCatalogDataSource)
}