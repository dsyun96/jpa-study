**요약**
- 자동 생성 키를 얻는 방법 3가지
  - `getId()` : 엔터티 save 후 getId()
  - `JdbcTemplate` : JdbcTemplate의 update(psc, generatedKeyHolder) 메서드 사용
  - `SimpleJdbcInsert` : executeAndReturnKey() 메서드 사용
