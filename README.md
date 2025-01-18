**요약**
- SEQUENCE 생성자는 MySQL에서 지원하지 않음(PostgreSQL에서는 지원)
- SEQUNCE 생성자는 SELECT문을 통해 새 시퀀스 값을 DB로부터 생성
  - 이는 하이버네이트 고유 hi/lo 알고리듬을 통해 최적화 가능
```java
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo")
@GenericGenerator(name = "hilo",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
        @Parameter(name = "sequence_name", value = "hilo_sequence"),
        @Parameter(name = "initial_value", value = "1"),
        @Parameter(name = "increment_size", value = "100"),
        @Parameter(name = "optimizer", value = "hilo")
    }
)
private Long id;
```
- hi 값은 DB 시퀀스에서 가져오며, 이를 사용해 메모리 내에 lo 항목 개수를 나타내는 구성 가능한 증가분 개수만큼 식별자 생성
- 모든 lo 값이 사용되면 새 DB 호출을 통해 다른 새로운 hi 값을 가져오는 방식
- 외부 시스템이 있는 경우, 해당 시스템도 hi/lo 존재를 인식하여 처리하거나 다른 하이버네이트 전용 옵티마이저를 사용할 것 
