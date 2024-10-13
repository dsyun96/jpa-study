# 요약
- findById를 사용하면 실제로 엔티티를 조회함(영속성 컨텍스트, 2차 캐시, DB 순서로)
- 하지만 getOne을 사용하면 실제로 사용하기 전까지 프록시 객체를 사용함
- 따라서 getOne을 사용하는 게 더 이득이다. 모든 상황에서 이득인지는 모르겠음.
# 이슈
- getOne으로 하면 프록시 객체를 사용한다고 하는데, 그렇지 않았음
- getOne, getById, getReferenceById 전부 동일
- 호출 시점에 select 쿼리가 발생

## 원인?
- 아마 MySQL이 아니라 H2를 사용해서?
    - MySQL로 확인해보니 동일한 결과였음
- 스프링부트 버전에 따른 차이? (2.5부터 getOne이 deprecated 되었다고 함)
    - 일단 기존 버전은 3.3.4 였음
    - 2.4.5로 바꾸고, gradle 버전도 6.8.3으로 바꾸고, 코틀린 버전도 1.4.32로 바꾸고 하니 그제서야 수많은 에러를 해결하고 select 쿼리가 발생 안 하는 것을 확인함
