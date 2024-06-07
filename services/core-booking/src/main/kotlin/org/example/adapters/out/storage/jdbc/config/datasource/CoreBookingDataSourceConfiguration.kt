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
class CoreBookingDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.jdbc.core-booking")
    fun coreBookingDataSourceProperties(): DataSourceProperties = DataSourceProperties()

    @Bean
    fun coreBookingDataSource(): DataSource = coreBookingDataSourceProperties()
        .initializeDataSourceBuilder()
        .build()

    @Bean
    fun coreBookingAtomikosDataSource(
        @Value("\${spring.datasource.jdbc.core-booking.xa.properties.username}") user: String,
        @Value("\${spring.datasource.jdbc.core-booking.xa.properties.password}") password: String,
        @Value("\${spring.datasource.jdbc.core-booking.xa.properties.url}") url: String,
        @Value("\${spring.datasource.jdbc.core-booking.xa.data-source-class-name}") dscn: String
    ) = AtomikosDataSourceBean().also {
        it.uniqueResourceName = "coreBooking"
        it.xaDataSourceClassName = dscn
        it.xaProperties["user"] = user
        it.xaProperties["password"] = password
        it.xaProperties["url"] = url
        it.maxPoolSize = 100
    }

    @Bean
    fun coreBookingJdbcTemplate(@Qualifier("coreBookingAtomikosDataSource") coreBookingDataSource: DataSource) =
        NamedParameterJdbcTemplate(coreBookingDataSource)
}