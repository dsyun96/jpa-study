**요약**
```java
@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books")
    List<Author> fetchWithDuplicates();
}
```
- Author와 Book이 양방향 지연 일대다 연관관계를 갖고 있을 때, `fetchWithDuplicates()`를 호출하면 Author가 중복됨
  - 5명의 저자가 있고 각 저자가 3권의 도서를 갖고 있는 경우 15개의 요소가 반환(힙에 5개의 인스턴스와 이에 대한 10개의 참조가 존재)
- 이를 해결하려면 쿼리를 `SELECT DISTINCT a`로 수정
  - 이러면 실제로 중복 항목이 제거됨
  - 하지만 DISTINCT 키워드가 DB로 전달되어 불필요한 오버헤드가 추가됨(PostgreSQL은 HasAggregate 단계 사용, MySQL은 임시 테이블 생성)
- 하이버네이트의 5.2.2의 `QueryHints.HINT_PASS_DISTINCT_THROUGH` 힌트 추가함으로써 해결 가능
```java
@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books")
    @QueryHints(value = @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false"))
    List<Author> fetchWithDuplicates();
}
```
- 중복 항목 제거되고, 불필요한 오버헤드도 포함되지 않음

**주의**
- `HINT_PASS_DISTINCT_THROUGH`는 `hibernate.use_sql_comments` 속성이 활성화된 경우 작동하지 않음
