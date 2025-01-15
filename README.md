**요약**
- `@MappedSuperclass`는 기반 클래스가 있는 상속 모델을 구성하는 데 유용한 엔터티 수준 어노테이션
  - 기반 클래스는 abstract일 수도 있고 아닐 수도 있음
```java
@MappedSuperclass
public abstract class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String isbn;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;
}

@Entity
public class Ebook extends Book implements Serializable {
    // ...
}

@Entity
public class Paperback extends Book implements Serializable {
    // ...
}
```
- Ebook, Paperback은 Author와의 ManyToOne 연관관계를 가지나 Author는 @OneToMany 연관관계를 정의할 수 없음
- `@MappedSuperclass` 장단점
  - 장점 : 읽기/쓰기 빠름, 기반 클래스가 엔터티일 필요 없는 경우 클래스당 테이블 상속 전략에 대한 적절한 대안
  - 단점 : 기반 클래스에 대한 쿼리 불가능, 다형성 쿼리 및 연관관계 허용되지 않음
