**요약**
```java
public interface AuthorDto {
    String getName();
    int getAge();
}

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(
        value = "SELECT * FROM (SELECT name, age, ROW_NUMBER() OVER (ORDER BY age) AS row_num FROM author) AS a " +
                "WHERE row_num BETWEEN ?1 AND ?2",
        nativeQuery = true
    )
    List<AuthorDto> fetchPage(int start, int end);
}
```
- `ROW_NUMBER()` 윈도우 함수를 사용하여 페이지네이션 가능
- 총 행수도 가져와야 하면 total 필드 추가 및 `COUNT(*) OVER()` 윈도우 함수 추가
```java
public interface AuthorDto {
    String getName();
    int getAge();
    long getTotal();
}

@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(
        value = "SELECT * FROM" +
                "(SELECT name, age, COUNT(*) OVER() AS total, ROW_NUMBER() OVER (ORDER BY age) AS row_num FROM author) AS a " +
                "WHERE row_num BETWEEN ?1 AND ?2",
        nativeQuery = true
    )
    List<AuthorDto> fetchPage(int start, int end);
}
```
