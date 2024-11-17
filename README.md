**요약**
- CompletableFuture는 JDK 8에 추가됨
- `CompletableFuture.allOf()`는 여러 작업을 비동기적으로 실행하고 완료될 때까지 대기하고, 여러 작업은 등록 배치가 됨
- `CompletableFuture.runAsync()`는 작업을 비동기적으로 실행하며 결과를 반환하지 않음(결과 반환이 필요하면 supplyAsync() 사용)
