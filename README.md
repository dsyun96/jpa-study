**요약**
- JPQL에서 SELECT 절 안에 생성자를 사용하여 자바 객체 인스턴스 반환 가능
```java
@Repository
@Transactional(readOnly = true)
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT new com.bookstore.dto.AuthorDto(a.name, a.age) FROM Author a")
    List<AuthorDto> fetchAuthors();
}
```
