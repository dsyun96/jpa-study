**요약**
- 새로운 엔터티 저장 : `@PrePersist`, `@PostPersist`
- 엔터티 가져오기 : `@PostLoad`
- 엔터티 수정 : `@PreUpdate`, `@PostUpdate`
- 엔터티 삭제 : `@PreRemove`, `@PostRemove`
- 여러 엔터티에 대해 JPA 콜백을 호출하고 싶다면 base 클래스를 만들어서 `@MappedSuperClass` 어노테이션을 적용하고 상속시킬 것
  - 이후 Listener를 작성하고 위 base 클래스에 `@EntityListeners(BookListener::class)` 적용
