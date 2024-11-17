**요약**
- MySQL 배치 삭제는 jdbc url 설정 필요
  - `jdbc:mysql://localhost:3306/bookstoredb?cachePreStmts=true&useServerPrepStmts=true&rewriteBatchedStatements=true`
- 다른 RDBMS의 경우
  - MySQL 관련 설정 제거하고
  - `spring.jpa.properties.hibernates.jdbc.batch_size` 값 설정
- 버전이 지정된 엔터티
  - `spring.jpa.properties.hibernate.jdbc.batch_versioned_data=true`
  - 하이버네이트 5부터는 기본적으로 활성화 됨
- 가장 적합한 배치 삭제 방법을 결정하려면 **배치 처리가 연관관계에 영향을 미치는지 + 얼마나 많은 데이터가 삭제되는지**가 중요함
- 벌크 작업을 트리거하는 메서드
  - `deleteAllInBatch()`
  - `deleteAllInBatch(entities: Iterable<T>)`
- `deleteAllInBatch()` 메서드를 통한 삭제
  - 배치 처리가 사용되진 않지만 DB에서 모든 레코드를 삭제하는 매우 효율적인 방법
  - 하지만 영속성 콘텍스트는 자동으로 업데이트/동기화되지 않음
  - 삭제 전에 플러시 + 삭제 + 삭제 후 영속성 콘텍스트 클리어 또는 클로즈
- `deleteInBatch(entities: Iterable<T>)` 메서드를 통한 삭제
  - 전부 WHERE절에서 id가 OR로 연결되어서 쿼리가 발생
  - 모든 레코드 삭제할 때는 `deleteAllInBatch()` 활용할 것
- `deleteAll(entities: Iterable<T>)` 메서드를 통한 삭제
  - 배치 처리가 사용되며, 자동 낙관적 잠금 메커니즘의 이점과 함께 업데이트 손실도 방지됨
  - `deleteAll()`은 내부적으로 `findAll()`을 호출함
- `delete(entity: T)` 메서드를 통한 삭제
  - `deleteAll(entities: Iterable<T>)`를 사용하는 것과 유사함

**단점**
- 일반적으로 벌크 작업은 배치 처리보다 빠르고 인덱스를 활용할 수 있으나
- 전이 메커니즘 또는 자동 애플리케이션 수준 낙관적 잠금 메커니즘의 장점을 얻지 못함
- 또한, 엔터티에 대한 수정 사항이 영속성 콘텍스트에 자동으로 반영되지 않음

**의문**
- 408p. 삭제 후에는 영속성 콘텍스트가 자동으로 클로즈 된다고 하는데, 그러면 개발자는 삭제 전에 플러시만 잘 해주면 되는가
