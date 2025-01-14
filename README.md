**요약**
- JPA 쿼리 메서드로 조회하면 dtype 조건이 자동으로 붙지만, @Query JPQL로 조회하면 자동으로 붙지 않음
- `SELECT b FROM Author a JOIN a.books b WHERE a.name = ?1 AND TYPE(b) = 'Ebook` 처럼 조건 추가하여 해결
