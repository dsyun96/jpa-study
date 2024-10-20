# 요약
- application.yaml 설정으로 파라미터 최적화
```yaml
spring:
  datasource:
    hirari:
      connectionTimeout: 50000
      idleTimeout: 300000
      maxLifetime: 900000
      maximumPoolSize: 8
      minimumIdle: 8
      poolName: MyPool
      connectionTestQuery: select 1 from dual
      autoCommit: false # auto-commit 비활성화
```

- DataSourceBuilder로 파라미터 최적화
```kotlin
@Configuration
class ConfigureDataSource {
    @Bean
    fun dataSource(): HikariDataSource {
        return HikariDataSource().apply {
            jdbcUrl = "..."
            username = "root"
            password = "root"
            connectionTimeout = 50_000
            // ...
            autoCommit = false
        }
    }
}
```
