**요약**
- 애플리케이션 수준 배치 크기 설정
  - `spring.jpa.properties.hibernate.jdbc.batch_size` 값을 통해 application.properties로 처리
- 하이버네이트 5.2부터 세션 수준 배치 크기 설정 가능
  - `Session.setJdbcBatchSize()` 메서드 사용
  - 스프링 부트에서 세션에 액세스하려면 `EntityManager#unwrap()`을 통해 가져와야 함
