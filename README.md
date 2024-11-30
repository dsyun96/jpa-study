**요약**
- 애플리케이션이 지연 연관관계를 가지고 있지만 일부 데이터는 즉시 가져왕냐 할 때 : JOIN, JOIN FETCH
  - 엔터티 수준에서 FetchType.EAGER를 사용하는 것은 코드 스멜
- JOIN FETCH -> 하나의 SELECT로 연관관계 초기화 가능
- JOIN -> 연관관계 초기화되지 않음
  - 중요1. 추가 SELECT로 도서를 가져옴
  - 중요2. 추가 SELECT에서 저자의 모든 도서를 가져오므로 JOIN FETCH와 결과가 다름
- 데이터를 엔터티로 가져와야 할 때 JOIN FETCH를 쓰고, 읽기 전용 데이터를 가져올 때는 JOIN + DTO를 쓸 것
