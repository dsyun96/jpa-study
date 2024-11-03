**요약**
- @Where는 `JOIN FETCH WHERE` 또는 `@NamedEntityGraph`가 적용 사례에 적합하지 않은 경우에만 사용할 것
- JOIN FETCH WHERE를 사용하는 것이 2가지 측면에서 나음
  - 저자를 가져오는 하나의 SELECT로 연관된 도서를 가져옴
  - 주어진 가격을 쿼리 바인딩 파라미터로 전달 가능
- @Where가 유용한 예시 : 소프트 삭제
