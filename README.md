**요약**
- 소프트 삭제는 보통 삭제 여부를 나타내는 칼럼으로 구현하나, 타임스탬프 또는 `@Enumerated`로도 제어 가능
- 하이버네이트는 다음과 같이 구현 가능
```java
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "deleted")
    protected boolean deleted;
}

@Entity
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Author extends BaseEntity implements Serializable {
    // ...
}

@Entity
@SQLDelete(sql = "UPDATE book SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Book extends BaseEntity implements Serializable {
    // ...
}
```
- 복원은 JPQL을 통해 수행 가능
```java
@Transactional
@Query(value = "UPDATE Author a SET a.deleted = false WHERE a.id = ?1")
@Modifying
void restoreById(Long id);
```
- 소프트 삭제된 레코드를 포함해서 조회하려면 네이티브 쿼리를 사용
- 영속성 콘텍스트에서는 deleted 속성을 업데이트 하지 않음
  - 참조된 엔터티는 삭제 후 즉시 해제되기 때문
  - 그럼에도 참조된 엔터티가 여전히 사용 중이라면 deleted 속성을 직접 업데이트 해야 함
  - 이를 수행하는 가장 좋은 방법은 JPA `@PreRemove` 수명주기 콜백 사용
```java
@PreRemove
private void authorRemove() {
    deleted = true;
}
```
