package org.example.adapters.out.storage.jdbc.config.jta

import com.atomikos.icatch.jta.UserTransactionManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.jta.JtaTransactionManager

@Configuration
@EnableTransactionManagement
class TransactionManagerConfiguration {
    @Bean(initMethod = "init", destroyMethod = "close")
    fun userTransactionManager(): UserTransactionManager {
        val transactionManager = UserTransactionManager()
        transactionManager.forceShutdown = true
        return transactionManager
    }

    @Bean
    @Primary
    fun jtaTransactionManager(): JtaTransactionManager = JtaTransactionManager().apply {
        transactionManager = userTransactionManager()
        userTransaction = userTransactionManager()
    }
}