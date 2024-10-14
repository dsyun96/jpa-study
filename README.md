# 요약
- application.yml 설정의 `spring.transaction.default-timeout` 속성으로 전역 타임아웃 설정 가능
- @Transactional의 timeout 항목 지정으로 타임아웃 설정 가능
- QueryHints로 `org.hibernate.timeout` (초 단위) 혹은 `javax.persistence.query.timeout` (밀리초 단위) 를 통해 쿼리 수준 타임아웃 설정 가능
- TranactionTemplate의 setTimeout을 통해 초 단위 타임아웃 설정 가능
- 로깅 레벨 변경해서 롤백 되는 건 보이지만 "At this point ~" 문구는 보이지 않았음 (아마 버전 이슈?)

# 이슈
- sleepQuery로 아무리 해도 동작을 안 해서 뭔가 했는데, H2 데이터베이스 문제였음
    - MySQL로 변경해서 테스트 했더니 바로 동작함
