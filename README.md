**요약**
- OPTIMISTIC_FORCE_INCREMENT
  - `@Version`과 `OPTIMISTIC_FORCE_INCREMENT` 잠금 전략
  - 루트 엔터티에 version 필드를 추가하고 `@Version` 어노테이션 적용
  - 리포지터리에서 조회하는 메서드에 `@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)` 적용
- PESSIMISTIC_FORCE_INCREMENT
  - OPTIMISTIC_FORCE_INCREMENT은 현재 트랜잭션이 끝날 때 버전을 증가시킴
  - PESSIMISTIC_FORCE_INCREMENT는 즉시 버전을 증가시킴
