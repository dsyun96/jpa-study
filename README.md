# 요약
- @Transactional이 무시되지 않기 위해 2가지 조건이 필요
    - public 메서드에서만 작동한다
    - 다른 클래스에서 호출되어야 한다

# 궁금증
- 실제로, private 메서드에 @Transactional을 붙이면 컴파일 타임에 에러가 뜬다
    - `Methods annotated with '@Transactional' must be overridable `
- 그리고 intelliJ IDEA 에서는 친절하게 public으로 바꾸는 것을 추천한다
- 근데, protected로 바꿔도 에러는 사라진다. 이래도 괜찮은가?
- 스프링 공식문서에서는 public 이외의 모든 메서드는 트랜잭션이 적용되지 않는다고 한다.
- 자세한 내용은 [AOP에 대한 사실과 오해 그런데 트랜잭션을 사알짝 곁들인.. (tistory.com)](https://giron.tistory.com/140)
- 결론 - @Transactional은 무조건 public 메서드에 적용할 것
