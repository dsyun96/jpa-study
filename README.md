**요약**
- Publisher 엔터티와, 저자 이름으로 구성된 복합키를 Author 엔터티가 갖는 상황
    ```kotlin
    @Embeddable
    data class AuthorId(
        @ManyToOne
        @JoinColumn(name = "publisher")
        val publisher: Publisher = Publisher(),
  
        @Column(name = "name")
        val name: String = ""
    ) 
    ```
- Author 엔터티
    ```kotlin
    @Entity
    class Author(
        @EmbeddedId
        val id: AuthorId,
  
        // ...
    )
    ```
- Book 엔터티
    ```kotlin
    @Entity
    class Book(
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumns([
            JoinColumn(name = "publisher", referencedColumnName = "publisher"),
            JoinColumn(name = "name", referencedColumnName = "name")
        ])
        val author: Author,
  
        // ...
    )
    ```
