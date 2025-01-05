**요약**
```kotlin
@Entity
class ShoppingCart(
    // ...
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "shopping_cart_books", joinColumns = JoinColumn(name = "shopping_cart_id"))
    val books: List<Book> = listOf()
)
```
- ShoppingCart의 owner와 books의 title, price를 포함하는 읽기 전용 데이터 결과 세트를 가져올 때는 JOIN을 사용할 것 
