**요약**
```kotlin
@Query(value = """
    WITH sales AS (
        SELECT *, ROW_NUMBER() OVER (PARTITION BY name ORDER BY sold DESC) AS row_num
        FROM author
    )
    SELECT * FROM sales WHERE row_num <= ?1
""")
fun fetchTopNBySales(n: Int): List<Author>
```
- CTE(Common Table Expression)와 `ROW_NUMBER()` 윈도우 함수를 통해 구할 수 있음
