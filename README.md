**요약**
- Author 엔터티에 `@OneToMany` 양방향 연관관계 Book이 있는 상황에서
```java
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b FROM Book b JOIN b.author a WHERE a.name = ?1")
    List<Book> booksOfAuthor(String name);
}
```
- 위와 같은 메서드를 호출하면 반환된 List<Book>은 detached 상태
  - 따라서, 내용을 수정해도 DB에 반영되지 않음
- 이 detached 된 books를 author에 설정하는 방법
  - 더 이상 존재하지 않는 DB 행을 제거
  - 존재하는 DB 행을 업데이트
  - 새로운 도서를 추가
- 일반적으로는 부모 엔터티와 연관된 자식 엔터티 컬렉션을 가져오고, detached 상태에서 컬렉션 수정 후 부모 엔터티 병합
