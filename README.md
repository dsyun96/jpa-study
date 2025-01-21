- 공유/읽기 잠금 : 동시 읽기는 허용하지만, 쓰기는 허용하지 않음
- 배타적/쓰기 잠금 : 쓰기가 진행 중인 동안, 읽기/쓰기 모두 허용하지 않음
- 스프링부트에서 다음처럼 쿼리 수준에서 공유/배타적 작금 획득 가능
```java
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_READ) // 배타적 잠금은 LockModeType.PESSIMISTIC_WRITE
    Optional<Author> findById(Long id);
}
```
### 시나리오
  - step 1. 트랜잭션 A는 id가 1인 저자 가져옴
  - step 2. 트랜잭션 B도 id가 1인 저자 가져옴
  - step 3. 트랜잭션 B가 저자의 장르 수정
  - step 4. 트랜잭션 B가 커밋
  - step 5. 트랜잭션 A가 커밋

### PESSIMISTIC_READ(공유 잠금)일 경우
- step 1. 트랜잭션 A는 id가 1인 저자를 가져오고 공유 잠금 획득
- step 2. 트랜잭션 B도 id가 1인 저자를 가져오고 공유 잠금 획득
- step 3. 트랜잭션 B가 저자의 장르 수정
- step 4. 트랜잭션 A가 공유 잠금을 유지하는 한, 해당 행을 수정하기 위한 잠금을 획득할 수 없기 때문에 트랜잭션 B는 타임아웃
- step 5. 트랜잭션 B로 인해 QueryTimeoutException 발생

- MySQL에서의 MySQL5Dialect (MyISAM)
  - `LOCK IN SHARE MODE` 구문 활용 
  - 공유 잠금 획득을 위한 구문이 있더라도 쓰기를 방지하지 않음
- MySQL에서의 MySQL5InnoDBDialect, MySQL8Dialect (InnoDB)
  - `FOR SHARE` 구문 활용
  - 예상대로 잠금이 적용되고 쓰기 방지
- PostgreSQL에서의 PostgreSQL95Dialect
  - `FOR SHARE` 구문 활용
- 오라클
  - 행 수준 공유 잠금 지원하지 않음
- SQL 서버
  - `WITH(HOLDLOCK, ROWLOCK)` 테이블 힌트를 통해 공유 잠금 획득

### PESSIMISTIC_WRITE(배타적 잠금)일 경우
- step 1. 트랜잭션 A는 id가 1인 저자를 가져오고 배타적 잠금 획득
- step 2. 트랜잭션 B도 id가 1인 저자를 가져오고 배타적 잠금 획득하려고 시도
- step 3. 트랜잭션 A가 배타적 잠금을 갖고 있는 한, 해당 행을 수정하기 위한 잠금을 획득할 수 없어 트랜잭션 B는 타임아웃
- step 4. 트랜잭션 B로 인해 QueryTimeoutException 발생

- MySQL에서의 MySQL5Dialect (MyISAM)
  - `FOR UPDATE` 구문 활용
  - 배타적 잠금 획득을 위한 구문이 있더라도 배타적 잠금을 획득하지 않음
- MySQL에서의 MySQL5InnoDBDialect, MySQL8Dialect (InnoDB)
  - `FOR UPDATE` 구문 활용
  - 예상대로 작동
- PostgreSQL에서의 PostgreSQL95Dialect
  - `FOR UPDATE` 구문 활용
- 오라클
  - `FOR UPDATE`를 통해 배타적 잠금 획득
- SQL 서버
  - `WITH(UPDLOCK, HOLDLOCK, ROWLOCK)` 테이블 힌트를 통해 배타적 잠금 획득
