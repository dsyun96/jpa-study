**요약**
- 도서 A를 조회하는 동안, 도서 A의 저자의 도서 중에서 다음으로 저렴한 도서를 조회하고 싶은 경우
  - `SELECT * FROM book WHERE price < ?1 AND author_id = ?2 ORDER BY price DESC LIMIT 1` 쿼리를 사용해서 가능
  - 하지만 이 경우 2개의 SELECT문이 필요함
  - `@JoinFormula`를 사용하면 1번의 쿼리로 가능
    ```kotlin
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinFormula("""(
        SELECT b.id FROM book b
        WHERE b.price < price AND b.author_id = author_id
        ORDER BY b.price DESC
        LIMIT 1
    )""")
    val nextBook: Book
    ```
