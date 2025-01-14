**요약**
```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Book implements Serializable {
    // ...
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
- book 테이블은 Ebook 및 Paperback 엔터티의 연관된 모든 칼럼을 포함
  - dtype 이라는 구분자 칼럼(JPA 영속성 공급자에 의해 추가됨)도 포함하며, 하이버네이트는 이 구분자 칼럼으로 결과 세트를 연관된 하위 클래스 인스턴스에 매핑
- Paperback 리포지터리로 조회할 경우 WHERE 절에 dtype 조건이 추가되며, Book을 조회할 경우 null이 반환됨
- 기반 클래스의 경우 not-nullable 제약은 간단히 가능
  - 하위 클래스는 기반 클래스처럼 간단히 할 수 없음
  - `@NotNull`로도 가능은 하지만 네이티브 쿼리로 우회가 됨
  - MySQL의 경우 트리거로 처리 가능

```mysql
CREATE TRIGGER ebook_format_trigger
    BEFORE INSERT ON book
        FOR EACH ROW
BEGIN 
    IF NEW.DTYPE = 'Ebook' THEN
        IF NEW.format IS NULL THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT='The format of e-book cannot be null';
        END IF;
    END IF;
END;
```
- 구분자 칼럼 메모리 최적화
```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        columnDefinition = "TINYINT(1)"
)
@DiscriminatorValue("1")
public class Book implements Serializable {
// ...
}

@Entity
@DiscriminatorValue("2")
public class Ebook extends Book implements Serializable {
// ...
}

@Entity
@DiscriminatorValue("3")
public class Paperback extends Book implements Serializable {
// ...
}
```

- 단일 테이블 상속 장단점
  - 장점: 읽기/쓰기 빠름, @ManyToOne, @OneToOne, @OneToMany 효율적, 기반 클래스 속성은 not-nullable 제약 가능
  - 단점: 하위 클래스 칼럼은 not-nullable 허용되지 않음(하지만 트리거로 해결 가능)
