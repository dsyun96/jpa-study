# 요약
- 기본 @ManyToMany 매핑을 사용하려면 관계의 오너와 mappedBy 측을 선택해야 함
  - 이때, List 대신 Set을 사용할 것
- 좀 더 많이 사용되는 쪽에 도우미 메서드를 추가하여 사용하면 연관관계 양쪽을 쉽게 동기화 상태로 유지 가능
- CascadeType의 ALL, REMOVE 사용하지 않기
  - 대신, PERSIST와 MERGE를 사용할 것
  - `@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})`
  - 또한 orphanRemoval 옵션도 ManyToOne, ManyToMany에서는 지정되지 말아야 함(OneToXxx는 가능)
- @joinTable로 조인 테이블명과 칼럼명을 명시적으로 설정하면 혼동 없이 정보 참조 가능
- 연결 테이블을 별도 엔터티에 매핑함으로써 2개의 양방향 @OneToMany 연관관계로 대체할 수 있음
