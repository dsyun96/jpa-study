**요약**
- `spring.datasource.initialization-mode`로 가능한 값은 always, never, embedded
  - embedded는 내장된 DB(e.g. H2)를 사용하는 경우만 스키마를 초기화하도록 스프링부트에 지시
```yaml
spring:
  datasource:
    initialization-mode: always
    platform: mysql
```
- 위와 같이 설정 후 `schema-mysql.sql`를 작성하면 애플리케이션이 시작할 때마다 SQL문 실행
