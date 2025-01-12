**요약**
- 스프링 데이터 JPA 감사 또는 하이버네이트 지원을 통해, 자동 생성 영속 필드를 엔터티에 추가 가능
  - 두 경우 모두 해당 필드들은 `@MappedSuperClass`로 어노테이션이 지정된 추상 클래스(엔터티 아님)에 추가됨
- 아래는 스프링 데이터 감사 기능을 활용한 방법
```java
@MappedSuperClass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity<U> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @CreatedDate
    protected LocalDateTime created;
    
    @CreatedBy
    protected U createdBy;
    
    @LastModifiedDate
    protected LocalDateTime lastModified;
    
    @LastModifiedBy
    protected U lastModifiedBy;
}
```
- `AuditingEntityListener`는 스프링 데이터 JPA 엔터티 리스너 클래스
  - 콜백 메서드를 사용해 created, createdBy, lastModified, lastModifiedBy 필드를 저장하고 업데이트
- 현재 로그인한 사용자 정보를 JPA에게 제공하기 위해 개발자는 AuditorAware 구현을 작성하고 getCurrentAuditor() 메서드 재정의 해야 함
- 마지막으로 설정 클래스에 `@EnableJpaAuditing(auditorAwareRef = "auditorAware")`을 지정하면 JPA 감사 기능이 활성화 됨
- 하이버네이트는 다른 방식으로 해야 함
  - created의 경우 `@CreationTimestamp`, lastModified는 `@UpdateTimestamp`
  - createdBy, lastModifedBy의 경우 고유 내장 어노테이션이 없음
    - 하이버네이트의 AnnotationValueGeneration 인터페이스를 통해 어노테이션 구성 가능
