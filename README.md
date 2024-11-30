**요약**
- 양방향 지연 @OneToMany 연관관계(저자-도서)에서, '도서를 포함해 이름으로 저자 가져오기' 또는 '저자를 포함해 ISBN으로 도서 가져오기' 상황일 때 다음과 같은 단점이 있음
  - 하나가 아닌 2개의 SELECT 발생
  - 지연 로딩은 LazyInitializationException을 피하고자 하이버네이트 세션을 유지해야 함
- SQL JOIN으로 가져오는 것도 실용적이진 않음 -> 항목 40 참고
- 엔터티 수준에서 연관관계를 LAZY에서 EAGER로 변경 -> 효과가 있지만 하지 말아야 함
- JOIN FETCH가 올바른 선택
```kotlin
@Repository
@Transactional(readOnly = true)
interface AuthorRepository : JpaRepository<Author, Long> {
    @Query(value = "SELECT a FROM Author a JOIN FETCH a.books WHERE a.name = ?1")
    fun fetchAuthorWithBooksByName(name: String): Author
}
```

**이해 안 가는 부분**
- p.326 'FetchType.LAZY는 추가 쿼리(N+1)를 유발한다'라고 첫 줄에 설명하고, 이후 '반면에 FetchType.LAZY를 사용하면 100개의 추가 쿼리가 발생한다'라고 설명하는데 살짝 이해가 안 감.
- p.326 '많은 수의 DB 처리보다 큰 카테시안 곱을 갖는 것이 좋다. 그럼에도 몇 개의 쿼리만으로 큰 카테시안 곱을 피할 수 있다면 해당 쿼리를 사용해야 한다.' 결국 뭘 사용하라는 것인지..? 
