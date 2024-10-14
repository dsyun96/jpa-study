# 요약
- 리포지토리에 @Transaction(readOnly = true)를 작성하고, 수정/삭제 등에 대해서는 @Transactional을 붙여 재정의할 것
- 스프링의 기본 트랜잭션 전파 메커니즘은 Propagation.REQUIRED
- 단일 데이터 소스 한정으로 다음의 설정은 항상 좋다
  ```
  spring:
    datasource.hikari.auto-commit: false
    jpa.properties.hibernate.connection.provider_disables_autocommit: true
    ```
- DB와 상호작용하지 않는 무거운 비즈니스 로직을 중간에 처리하는 트랜잭션을 사용하지 않도록 노력할 것
- 장기 실행 트랜잭션보다는 버전 기반 낙관적 잠금 또는 재시도 메커니즘 사용을 고려할 것
