**요약**
- 하이버네이트는 Boolean 타입을 JDBC 타입 4가지(BIT, INTEGER, CHAR(y/n), CHAR(t/f))를 확인하여 매핑하려고 시도
- 일치하는 것이 없으므로, 커스텀 컨버터 작성하는 것이 세련된 해결 방법
  ```kotlin
  @Converter(autoApply = true)
  class BooleanConverter : AttributeConverter<Boolean, String> {
      override fun convertToDatabaseColumn(attr: Boolean): String {
          return if (attr) "Yes" else "No"
      }
  
      override fun convertToEntityAttribute(dbData: String): Boolean {
          return "No" != dbData
      }
  }
  ```
- 특정 속성만을 지정하려면 autoApply를 제거하거나 false로 설정 후, 속성 수준에서 `@Convert(converter = BooleanConverter::class)` 추가
- `@Enumerated` 어노테이션이 달린 속성은 AttributeConverter 적용 불가
