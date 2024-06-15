package org.example.api.config

import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.postgresql.PostgresqlConnectionFactoryProvider
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.r2dbc.core.DatabaseClient

@Configuration
class R2dbcConfiguration {
    @Bean
    fun pgConnectionFactory(
        pgR2dbcProperties: R2dbcProperties,
    ): ConnectionFactory = PostgresqlConnectionFactory(
        PostgresqlConnectionFactoryProvider
            .builder(
                ConnectionFactoryOptions.parse(pgR2dbcProperties.url)
                    .mutate()
                    .option(ConnectionFactoryOptions.USER, pgR2dbcProperties.username)
                    .option(ConnectionFactoryOptions.PASSWORD, pgR2dbcProperties.password)
                    .build()
            )
            .build()
    )

    @Bean
    fun pgDatabaseClient(
        pgConnectionFactory: ConnectionFactory,
    ): DatabaseClient = DatabaseClient.create(pgConnectionFactory)
}