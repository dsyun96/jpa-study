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
- 도서를 즉시 가져오고 싶다면 JOIN FETCH를 사용할 것
