**요약**
- SQL 쿼리에 대한 세부 정보 확인 방법
  - DataSource-Proxy 사용
    1. pom.xml에 datasource-proxy 종속성 추가
    2. DataSource 빈을 인터셉트하기 위한 후처리기 빈 생성
    3. DataSource 빈을 ProxyFactory와 MethodInterceptor 구현을 통해 래핑
    4. 세부 정보 커스터마이징 후 build() 호출
  - log4jdbc 사용
    1. pom.xml에 log4jdbc-spring-boot-starter 종속성 추가
  - P6spy 사용
    1. pom.xml에 p6spy 종속성 추가
    2. application.yaml에 다음과 같은 JDBC url과 드라이버 클래스 이름 설정
      ```yaml
      spring:
        datasource:
          url: jdbc:p6spy:mysql://localhost:3306/bookstoredb
          driverClassName: com.p6spy.engine.spy.P6SpyDriver
      ```
    3. 애플리케이션 루트 폴더에 spy.properties 파일 추가
