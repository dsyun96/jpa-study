package com.example.jpastudy.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "ds1EntityManagerFactory",
    transactionManagerRef = "ds1TransactionManager",
    basePackages = ["com.example.jpastudy.ds1"]
)
@EnableTransactionManagement
class FirstEntityManagerFactory {
    @Bean
    @Primary
    fun ds1EntityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("dataSourceAuthorsDb") dataSource: DataSource?
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages(*packagesToScan())
            .persistenceUnit("ds1-pu")
            .properties(hibernateProperties())
            .build()
    }

    @Bean
    @Primary
    fun ds1TransactionManager(
        @Qualifier("ds1EntityManagerFactory") ds1EntityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(ds1EntityManagerFactory)
    }

    protected fun packagesToScan(): Array<String> {
        return arrayOf(
            "com.example.jpastudy.ds1"
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
