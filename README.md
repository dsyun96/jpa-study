**요약**
- 컬렉션에 `@BatchSize(size = n)` 어노테이션을 적용하면 배치 처리로 최대 n개의 컬렉션을 초기화 함
- 엔터티에 `@BatchSize(size = n)` 어노테이션을 적용하면 최대 n개의 참조되는 엔터티를 초기화 함
- 하지만 @BatchSize를 고려하기 전에 다른 방법들을 먼저 검토하는 것이 좋음
