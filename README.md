**요약**
```mysql
CREATE OR REPLACE VIEW GENRE_AND_TITLE_VIEW
AS
SELECT
    a.genre,
    b.title
FROM
    author a
INNER JOIN
    book b ON b.author_id = a.id;
```
- 위와 같은 뷰가 있을 때, 내용을 확인하는 방법
  - 뷰를 해당 이름과 칼럼에 매핑하는 엔터티 정의
  - DB에 따라 뷰는 읽기 전용일 수 있으므로, `@Immutable` 어노테이션으로 뷰 수정 방지 가능
  - 일반적인 스프링 리포지터리 정의하고 나머지는 일반 테이블에서 조회하듯이
