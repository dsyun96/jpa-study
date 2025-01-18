**요약**
- MySQL과 하이버네이트5에서 `GenerationType.AUTO` 생성자 타입은 TABLE 생성자를 사용 -> 성능 저하
- TABLE 생성자 타입은 확장성도 없고, IDENTITY나 SEQUENCE 생성자 타입보다 훨씬 느림
- 단일 엔터티를 insert할 때 3개의 쿼리가 발생(SELECT, UPDATE, INSERT)
- IDENTITY를 사용하거나, native 생성자 타입 사용
```java
@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
@GenericGenerator(name = "natvie", strategy = "native")
private Long id;
```
