package com.example.jpastudy.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class ConfigureDataSources {
    @Primary
    @Bean(name = ["configAuthorsDb"])
    @ConfigurationProperties("app.datasource.ds1")
    fun firstDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Primary
    @Bean(name = ["dataSourceAuthorsDb"])
    @ConfigurationProperties("app.datasource.ds1")
    fun firstDataSource(
        @Qualifier("configAuthorsDb") properties: DataSourceProperties
    ): HikariDataSource {
        return properties.initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean(name = ["configBooksDb"])
    @ConfigurationProperties("app.datasource.ds2")
    fun secondDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean(name = ["dataSourceBooksDb"])
    @ConfigurationProperties("app.datasource.ds2")
    fun secondDataSource(
        @Qualifier("configBooksDb") properties: DataSourceProperties
    ): HikariDataSource {
        return properties.initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }
}
