**요약**
- 기본키가 아닌 자연 ID를 참조하는 경우, `@JoinColumn(referenceColumnName = "email")` 을 통해 참조 가능
  - 이때, 항목의 값은 외래키로 사용해야 하는 DB의 칼럼 이름 
