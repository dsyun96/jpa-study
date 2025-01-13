**요약**
- @Transactional로 묶인 메서드 내에서 엔터티를 조회 후 수정하면, 하이버네이트 더티 체킹 메커니즘에 의해 플러시 시점에 UPDATE 수행
- save() 유무는 쿼리 수나 유형에 영향을 미치지 않지만 성능 저하 유발
  - save()가 MergeEvent를 내부적으로 발생시키고 하이버네이트의 여러 내부 동작(필요하지 않은)을 실행하기 때문
  - 따라서 save() 명시적 호출을 피하는 것이 좋음
