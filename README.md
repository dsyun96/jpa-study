# 요약
- 하이버네이트는 @ManyToMany 관계를 2개의 단방향 @OneToMany 관계로 처리함
- @ManyToMany 관계를 사용할 때는 항상 Set을 사용해야 함
  - 순서를 지정하고 싶으면 @OrderBy를 사용하거나 @OrderColumn을 사용할 수 있음
  - HashSet과 @OrderBy를 사용하면 비영속 상태에서는 일관성이 없을 수 있음
    - 비영속 상태에서도 일관성을 유지하려면 LinkedHashSet 사용
