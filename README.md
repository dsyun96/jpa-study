**요약**
- 엔터티 그래프는 `페치 그래프`와 `로드 그래프` 두 속성을 통해 현재 FetchType의 의미 체계를 재정의할 수 있음
  - 페치 그래프는 attributeNodes에 있는 속성은 EAGER로 처리되고, 나머지 속성은 기본/명시 FetchType에 관계없이 LAZY로 처리됨
  - 로드 그래프는 attributeNodes에 있는 속성은 EAGER로 처리되고, 나머지 속성은 기본/명시 FetchType에 따라 처리됨
- Bytecode Enhancement가 활성화되지 않으면 페치/로드 그래프 모두 @Basic 설정을 무시함
