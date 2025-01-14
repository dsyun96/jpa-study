**요약**
- 조인 테이블은 JPA 상속 전략 중 하나
  - 이 전략에 따라 상속 계층 구조의 모든 클래스는 DB 개별 테이블로 표현
```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Book implements Serializable {
    // ...
}

@Entity
@PrimaryKeyJoinColumn(name = "ebook_book_id")
public class Ebook extends Book implements Serializable {
    // ...
}

@Entity
@PrimaryKeyJoinColumn(name = "paperback_book_id")
public class Paperback extends Book implements Serializable {
    // ...
}
```
- @PrimaryKeyJoinColumn 어노테이션으로 외래키 커스터마이징 가능
- 기반 클래스의 데이터는 book 테이블에, 하위 클래스의 데이터는 각 테이블에 저장되므로 단일 테이블 상속 전략보다 더 많은 INSERT문 필요
- 기반 클래스 리포지터리를 통해 조회하면 N개의 조인이 발생하여 효율성에 영향을 미침
- 하위 클래스 리포지터리를 통해 하위 클래스를 조회할 경우 기반 클래스 테이블과의 조인 1개만 필요
- @OneToMany 연관 관계인 Author를 조회하면 연관된 도서 없이 저자를 가져오고, getBooks()를 호출하면 추가 쿼리(역시 N개의 조인)
- JOIN FETCH로 조회해도 N+1개의 조인(base class + 하위 클래스)
- 디자인 패턴으로 상속 전략을 구성하는 것이 JPA 상속을 활용하는 가장 좋은 방법
