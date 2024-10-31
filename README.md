**요약**
- 엔터티 그래프는 다음의 방법으로 정의 가능
  - @NamedEntityGraph 어노테이션 사용
  - @EntityGraph의 attributePaths 속성 사용 (애드혹 엔터티 그래프)
  - EntityManager API 사용

**주의할 점**
- 엔터티 그래프와 네이티브 쿼리를 함께 사용할 수 없음
