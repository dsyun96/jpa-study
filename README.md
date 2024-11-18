**요약**
- 트랜잭션 세부 정보 표시 설정
    ```yaml
    logging:
      level:
        ROOT: INFO
        org.springframework.orm.jpa: DEBUG
        org.springframework.transaction: DEBUG
        org.hibernate.engine.transaction.internal.TransactionImpl: DEBUG
    ```
- 커넥션 풀 상태를 기록하는 설정
  ```yaml
  logging:
    level:
      com.zaxxer.hikari.HikariConfig: DEBUG
      com.zaxxer.hikari: DEBUG
  ```
- 트랜잭션 콜백을 통한 제어권 확보
  - 전역 수준 : AOP 컴포넌트를 통해 처리
  ```kotlin
  @Aspect
  @Component
  class TransactionProfiler : TransactionSynchronizationAdapter {
      @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
      fun registerTransactionSynchronization() {
          TransactionSynchronizationManager.registerSynchronization(this)
      }
  
      override fun afterCompletion(status: Int) {
          logger.info("After Completion (global) ...")
      }
  
      override fun afterCommit(status: Int) {
          logger.info("After Commit (global) ...")
      }
  
      override fun beforeCompletion(status: Int) {
          logger.info("Before Completion (global) ...")
      }
  
      override fun beforeCommit(status: Int) {
          logger.info("Before Commit (global) ...")
      }
  
      companion object : KLogging()
  }
  ```
  - 메서드 수준 : 메서드 안에서 TransactionSynchronizationManager 사용
- 쿼리 메서드 실행 시간 로깅
  - AOP를 통해 메서드 실행 시간 기록 가능
