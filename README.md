**요약**
- IN 절에 서로 다른 길이의 리스트가 들어가면 각각의 실행 계획이 모두 캐시됨 (DB가 실행 계획 캐시를 지원하는 경우)
- `spring.jpa.properties.hibernate.query.in_clause_parameter_padding=true`로 설정해주면, 2의 제곱수 개수에 맞게 패딩을 넣어서 최적화
