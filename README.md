**요약**
- OSIV : Open Session In View
- OSIV는 안티패턴이고, 비생산적
  - 사용하는 이유 : 하이버네이트의 LazyInitializationException을 피하기 위해
  - OSIV는 뷰 계층이 프록시를 초기화할 수 있도록 영속성 콘텍스트를 열린 상태로 유지해 LazyInitializationException 방지
- OSIV의 주요 단점
  - 장기 실행 커넥션 해제를 기다리는 동시 요청들이 대기열에 있어서 커넥션 풀에 많은 부담 -> 커넥션 풀이 조기에 고갈될 수 있음
  - 명시적 트랜잭션 지정 없이 UI 렌더링 단계에서 실행된 명령문은 자동 커밋 모드에서 실행됨 -> DB는 많은 I/O 작업을 수행하게 됨
  - 서비스와 UI 계층은 DB에 명령문을 트리거할 수 있게 됨 -> SoC 위배, 테스트 복잡성 증가
