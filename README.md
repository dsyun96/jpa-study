**요약**
- MySQL에서 SELECT 절의 concat_ws() 함수는 하이버네이트에서 인식되지 않음
  - 하이버네이트 5.3부터 MetadataBuilderContributor를 통해 등록 가능
    ```kotlin
    class SqlFunctionsMetadataBuilderContributor : MetadataBuilderContributor {
        override fun contribute(metadataBuilder: MetadataBuilder) {
            metadataBuilder.applySqlFunction(
                "concat_ws",
                SQLFunctionTemplate(
                    StandardBasicTypes.STRING,
                    "concat_ws(' ', ?1, ?2, ?3, ?4)"
                )
            )
        }
    }
    ```
  - 또한 application.yaml에도 `spring.jpa.properties.hibernate.metadata_builder_contributor: com.bookstore.config.SqlFunctionMetadataBuilderContributor`
- WHERE 절에서는 function()을 이용하여 함수 호출을 하도록 JPA 2.1부터 지원
