**요약**
- 하이버네이트는 `@NaturalId` 어노테이션을 통해 업무 키를 자연 ID로 선언하는 것을 지원함
  - 스프링 스타일에서도 사용되게 변경할 수 있음
- 조회 방법
  - 엔터티에 하나의 `@NaturalId`만 있는 경우 : `Session.bySimpleNaturalId()`
  - 둘 이상 있는 경우 : `Session.byNaturalId()`
- equals()와 hashCode()는 자연 ID를 중심으로 구현할 것
- 설정 방법
  1. JpaRepository를 상속하는 NaturalRepository 작성
  2. NaturalRepository를 구현하는 NaturalRepositoryImpl 작성
  3. MainApplication에 `@EnableJpaRepositories(repositoryBaseClass = NaturalRepositoryImpl::class)` 적용

