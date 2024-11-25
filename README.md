**요약**
- 하이버네이트 타입 라이브러리는 JsonStringType과 JsonBinaryType 2가지 일반적인 json 타입 지원
- MySQL의 경우 JDBC 측면에서 json 타입을 String으로 표현해야 하므로 JsonStringType이 적합
```kotlin
import java.io.Serializable

@Entity
@TypeDef(
    name = "json",
    typeClass = JsonStringType::class
)
class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    
    val name: String,
    val genre: String,
    val age: Int,
    
    @Type(type = "json")
    @Column(columnDefinition = "json")
    val book: Book
) : Serializable
```
- json 쿼리 사용
  - JPQL : `SELECT a FROM Author a WHERE function('JSON_EXTRACT', a.book, '$.isbn') = ?1`
  - native : `SELECT a.* FROM author a WHERE JSON_EXTRACE(a.book, '$.isbn')`
