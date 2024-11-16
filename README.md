**요약**
- AbstractAggregateRoot<T>를 상속하여 registerEvent() 메서드를 호출함으로써 이벤트 등록이 가능
  - 등록된 이벤트는 스프링 데이터 리포지터리 save 메서드 중 하나를 호출하면 발행됨
- 동기식으로 실행하면 여러 가지 문제가 있음
  - 기본적으로 `TransactionPhase.AFTER_COMMIT` 이라서, 핸들러가 실행되기 전에 커밋되므로 속성을 수정한 후 save 하더라도 UPDATE 문이 실행되지 않음
  - UPDATE 문이 실행되게 하려면, @Transactional의 REQUIRES_NEW 전파 속성을 사용해야 함
  - 하지만 이 경우 2개의 DB 커넥션이 활성화 됨
  - `TransactionPhase.BEFORE_COMMIT`을 사용하면 @Transactional을 제거하고 하나의 장기 실행 트랜잭션만 가질 수 있음
  - AFTER_COMMIT + REQUIRES_NEW + auto-commit=false 설정으로도 save하는 시점 전까지 1개의 DB 커넥션을 유지할 수 있지만 여전히 별로임
- 비동기식으로 실행하려면 @EnableAsync로 비동기 기능을 활성화 후, 핸들러에 @Async를 적용해야 함
  - 이렇게 하면 핸들러가 실행되는 시점에 새로운 스레드와 새로운 트랜잭션을 요구함
  - 또한, DB 커넥션 획득은 save 전까지 지연됨
- 전체 요약 : 188p
