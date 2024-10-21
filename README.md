# 요약
- Page\<dto> (읽기 전용)
    - 데이터를 읽기 전용 엔터티로 가져오는 것을 피하고, 이후에 DTO로 변환하는 것이 더 좋은 방법
- Page\<entity> (수정 사항이 있을 때)
    - 엔터티에 total 필드를 추가하고, @Column(insertable = false, updatable = false) 추가

# 의문점
- 저번에 배울 땐 필요한 것만 가져오는 게 더 좋다고 했던 것 같은데, 이번 장에서는 반대로 얘기하고 있음(741p).
