# 요약
- JOIN FETCH와 Pageable을 결합할 경우, 그냥 사용하면 예외가 발생
    - Page 대신 Slice나 List로 반환타입을 바꾸면 예외가 발생하지 않음
    - 만약 총 레코드 수에 관심이 없다면 이렇게 해도 충분할 듯
- 카운트 쿼리를 추가해주거나, EntityGraph를 통해 처리할 수도 있음
- 이때, 페이지네이션은 전체를 불러와서 메모리에서 처리함 -> 컬렉션이 너무 크면 HHH000104 유형의 메시지가 표시됨
- 부모 측(Author)에서는 페이지네이션이 메모리에서 처리되지만, 자식 측(Book)에서는 페이지네이션이 DB에서 처리됨

# 이슈
- 직접 돌려보니 HHH000104가 아니라 HHH90003004 메시지가 표시됨
> HHH90003004: firstResult/maxResults specified with collection fetch; applying in memory

- 카운트 쿼리를 제거해도 예외없이 잘 돌아갔음
- 자식 측(Book)은 카운트 쿼리가 로그에 남지만, 부모 측(Author)는 카운트 쿼리가 남지 않음
