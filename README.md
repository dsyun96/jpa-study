# 요약
- HHH90003004은 경고로 보고되기 때문에, 다음의 속성을 활성화하여 예외로 보고시킬 수 있음
  - `spring.jpa.properties.hibernate.query.fail_on_pagination_over_collection_fetch=true`
- `COUNT(*) OVER()`를 사용하면 별도 COUNT 쿼리를 방지할 수 있음
- 총 레코드 수가 필요 없으면 Slice를 사용하는 것도 좋음
  - 자동으로 size+1 만큼 조회해서 다음 요소가 있는지 여부를 확인해주기 때문에 유용함
