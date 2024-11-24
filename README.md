**요약**
- 프리페어드 스테이트먼트 SQL문에 보이는 ?는 binding과 extracted 파라미터에 대한 위치 지정자
- 실제 값을 보는 방법 3가지
  - `logging.level.org.hibernate.type.descriptor.sql=TRACE` 설정
  - 스프링 부트의 기본 로깅을 제외하고 Log4j 종속성 추가 후 `org.hibernate.type.descriptor.sql`을 TRACE로 설정
  - MySQL의 경우 `spring.jpa.show-sql`을 false로 설정하고 JDBC url 상에 `logger=Slf4JLogger&profileSQL=true` 추가
