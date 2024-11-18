**요약**
- DataSource-Proxy 의존성 추가 및 후처리기 빈 등록
- `SLF4JQueryLoggingListener` 리스너를 정의하고 afterQuery() 메서드를 오버라이드
- 이후 listener를 사용해서 datasource 프록시 설정
- 하이버네이트 5.4.5 부터는 `hibernate.session.events.log.LOG_QUERIES_SLOWER_THAN_MS` 속성에 밀리초 단위로 임계치를 설정하여 느린 쿼리 기록 가능
