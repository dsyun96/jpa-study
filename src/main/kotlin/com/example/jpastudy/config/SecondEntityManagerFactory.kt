package com.example.jpastudy.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "ds2EntityManagerFactory",
    transactionManagerRef = "ds2TransactionManager",
    basePackages = ["com.example.jpastudy.ds2"]
)
@EnableTransactionManagement
class SecondEntityManagerFactory {
    @Bean
    fun ds2EntityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("dataSourceBooksDb") dataSource: DataSource?
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages(*packagesToScan())
            .persistenceUnit("ds2-pu")
            .properties(hibernateProperties())
            .build()
    }

    @Bean
    fun ds2TransactionManager(
        @Qualifier("ds2EntityManagerFactory") secondEntityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(secondEntityManagerFactory)
    }

    protected fun packagesToScan(): Array<String> {
        return arrayOf(
            "com.example.jpastudy.ds2"
        )
    }

    protected fun hibernateProperties(): Map<String, String> {
        return object : HashMap<String, String>() {
            init {
                put("hibernate.hbm2ddl.auto", "create")
            }
        }
    }
}
