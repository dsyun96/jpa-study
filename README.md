**요약**
- Review 엔터티가 Book, Article, Magazine 3개의 @ManyToOne 관계인 상황에서 제약 조건을 구현할 때
  - 애플리케이션 수준에서 제약 조건 구현 : Bean Validation 사용
  - 클래스 수준에서 제약 조건 구현 :
    ```kotlin
    class JustOneOfManyValidator : ConstraintValidator<JustOneOfMany, Review> {
        override fun isValid(review: Review, ctx: ConstraintValidatorContext): Boolean {
            return Stream.of(review.book, review.article, review.magazine)
                .filter { obj != null }
                .count() == 1
        }
    }
    ```

    ```kotlin
    @Target(AnnotationTarget.CLASS)
    @Retention(AnnotationRetention.RUNTIME)
    @Constraint(validatedBy = [JustOneOfManyValidator::class])
    annotation class JustOneOfMany(
        val message: String = "A review can be associated with either a book, a magazine or an article",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload?>> = []
    )
    ```

    위와 같이 클래스와 어노테이션을 정의 후, 엔터티에 `@JustOneOfMany` 적용
