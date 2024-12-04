**요약**
- 플루언트 API 스타일 적용 방법 2가지
  1. 엔터티의 도우미 메서드를 this를 반환하도록 작성
        ```kotlin
        val author = Author()
            .setName("Joana Nimar")
            .setAge(34)
            .setGenre("History")
            .addBook(Book()
                .setTitle("A History of Ancient Pargue")
                .setIsbn("001-JN")
            )
        ```
        근데... 코틀린의 경우 apply 스코프 함수를 쓰면 비슷할 것 같음.
  2. 별도 메서드를 작성
        ```kotlin
        val author = Author()
            .name("Joana Nimar")
            .age(34)
            .genre("History")
            .addBook(Book()
                .title("A History of Ancient Pargue")
                .isbn("001-JN")
            )
        ```
        Java에서나 차이가 있을 것으로 보이고, 코틀린에서는 의미 없어 보임.
