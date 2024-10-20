# 요약
- application.yml에 jdbc url과 커넥션 풀에 대한 구성을 추가하고
- ConfigureDataSources에서 각 데이터베이스에 대해 HikariDataSource 인스턴스 생성 후
- 각 HikariDataSource에 대해 LocalContainerEntityManagerFactoryBean과 PlatformTransactionManager를 구성
