**요약**
- 하이버네이트 5 이전의 더티 체킹 메커니즘은 자바 Reflaction API에 의존하여, 많은 수의 관리 엔터티가 있을 경우 성능 저하 발생할 수 있음
- 하이버네이트 5부터는 더티 트래킹 메커니즘을 의존함
  - 더 나은 성능을 보임
  - 이 메커니즘을 사용하려면 하이버네이트 Bytecode Enhancement 프로세스가 애플리케이션에 추가되어야 함
- 더티 트래킹 활성화 여부 확인(엔터티 클래스 디컴파일 후 코드 검색)
  ```java
  @Transient
  private transient DirtyTracker $$_hibernate_tracker;
  ```
- 플러시 되는 동안 하이버네이트는 $$_hibernate_hasDirtyAttributes() 메서드를 호출하고, 이 메서드는 더티 속성을 String[]으로 반환
- 하이버네이트 Bytecode Enhancement가 제공하는 주요 메커니즘 3가지
  - 더티 트래킹
  - 속성 지연 초기화
  - 연관관계 관리(양방향 연관관계에서의 자동 동기화)
