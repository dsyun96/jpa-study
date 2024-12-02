**요약**
- 프로덕션 환경에선 스키마 DDL를 데이터베이스로 반영하고자 할 때 `hibernate.ddl-auto`를 제거하거나 validate로 설정하고 Flyway 또는 Liquibase를 활용해야 함
- 신속한 Flyway 설정
  - Flyway 종속성 추가
  - `classpath:/db/migration` 경로에 Flyway 명명 규칙을 준수하여 파일명을 설정할 것
  - MySQL DB는 JDBC URL 상에 createDatabaseIfNotExist=true 파라미터로 생성 가능
 - Flyway를 통한 MySQL DB 생성
   - JDBC URL에서 DB 이름 제거
   - `spring.flyway.schemas=bookstoredb` 처럼 DB 업데이트 지시
   - `@Table(schema = "bookstoredb")` 를 엔터티에 적용하여 DB 이름을 알림
