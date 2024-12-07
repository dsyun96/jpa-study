**요약**
- 영속 필드가 아닌 값을 계산할 때 `@Transient` 어노테이션을 메서드에 적용하여 구현 가능하나, 호출될 때마다 수행하므로 조금 비효율적
- 필드에 `@Transient` 지정하고 `@PostLoad`를 private 메서드에 지정하여 엔터티 로드 후 최초 한 번만 계산하도록 하면 효율적
- `@Fomula` 어노테이션을 사용하여 SQL 쿼리 표현식으로도 가능
