**요약**
- findById로 엔터티를 찾고, genre를 변경한 후 save 한 상황 (이 2가지 작업은 @Transactional로 묶이지 않은 상태)
  - SELECT 1번, UPDATE 1번 트리거 될 것을 기대
  - 실제로는 SELECT 2번, UPDATE 1번 트리거
  - 첫 번째 SELECT로 가져온 엔터티는 managed 상태가 아니라서, 수정 전에 다시 가져와야 하기 때문
- 쿼리 카운트는 DataSource-Proxy 라이브러리를 사용해서 DataSourceQueryCountListener를 생성하도록 지시하여 확인 가능
