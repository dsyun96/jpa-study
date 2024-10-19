# 요약
- 일반적인 규칙으로 단방향 보다는 양방향 연관관계를 사용할 것
- 항상 부모 측에서 자식 측으로 전이할 것
-  기본적으로 @OneToMany는 Lazy, @ManyToOne은 Eagerly
    - 하지만 @ManyToOne도 지연으로 설정하고 쿼리 기반에서만 즉시 가져오게 하는 것이 좋음
- 자식 측 엔터티는 부모 측 엔터티에 대한 외래키를 갖는데, 의도된 이름을 지정할 것
    - 그래야 native query 등으로 참조할 때 잠재적인 혼동이나 실수 방지
    - @JoinColumn 어노테이션 사용
- 엔터티 삭제, 특히 자식 엔터티 처리에 주의할 것
    - CascadeType.REMOVE와 orphanRemoval=true가 처리되는 동안 많은 SQL문이 생성될 수 있음
    - 티스토리에서는 이런 설정을 적용하기 힘들 것 같음

# 추가로 배운 것
- Entity Manager는 객체를 처리할 때 사용되며, 내부에 캐시를 가짐 (1차 캐시)
- JPA 구현체들은 애플리케이션 수준에서의 캐시를 별도로 지원함 (2차 캐시)
- 기본적으로 @OneToMany는 Lazy, @ManyToOne은 Eagerly
