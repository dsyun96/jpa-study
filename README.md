**요약**
- ShoppingCart 엔터티의 필드 books에 `@ElementCollection` 적용한 상태일 때(title과 매핑)
  - 시작, 중간, 끝 부분에 도서 등록하는 경우 `shopping_cart_books` 테이블에서 모두 삭제 후 다시 등록
  - 시작, 중간, 끝 부분에 도서 삭제하는 경우 `shopping_cart_books` 테이블에서 모두 삭제 후 다시 등록
- `@OrderColumn` 어노테이션을 적용하면 최적화가 등록/삭제에 반영
  - 시작 부분에 등록 및 삭제하면 나머지 모든 요소가 UPDATE
  - 하지만 끝 부분에 등록 및 삭제하면 추가 UPDATE 필요 없음
