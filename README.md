# 요약
- 단방향 @ManyToOne은 효율적이다

# 이슈
- getReferenceById를 사용해도 SELECT 문이 발생하는 것은 여전함
- JPQL 쿼리를 통해 저자가 쓴 모든 도서를 가져오면 SELECT 문이 2번 발생함 (책 70p 내용과 다름)
- 71p에서도 2개의 SELECT 문은 맞지만 2번째 쿼리는 COUNT 쿼리가 아니라 SELECT author 쿼리
- authorId가 4인 author를 lazy fetch 설정했음에도 불구하고 자꾸 SELECT로 가져오는 이유를 모르겠음
  - `SELECT b FROM Book b JOIN FETCH b.author WHERE b.author.id = :authorId` 처럼 JOIN FETCH를 사용하면 한 번의 SELECT만 발생하지만 author는 여전히 가져옴
