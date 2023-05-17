## Full-Text Search로 TPS 개선하기

과거에 진행했던 프로젝트에 리팩토링을 진행하면서 검색 쿼리의 성능을 개선해보았다.  
  
### 인덱스를 쓰지 않는 쿼리
  
개선 대상은 특정 키워드로 게시글을 조회하는 쿼리다. 이 쿼리는 where 절에 like 문과 '%키워드%' 형태로 조건이 걸려 있었다.  
이런 방신의 쿼리는 풀 테이블 스캔을 한다. 인덱스를 쓰지 않기 때문에 개선할 점이 있을거라 판단했다.  
  
![img.png](img/Full-Text%20Search로%20TPS%20개선하기_img1.png)  
- type 값이 ALL, 즉 풀 테이블 스캔  

당연히 개선 방법으로 인덱스 사용이 가장 먼저 떠올랐지만, 한편으론 무수히 많은 문자열 조합이 가능한 TEXT 데이터에 인덱스를 생성하는 것이 가능할까? 하는 의문도 들었다.  
그러면 어쩔 수 없이 검색 엔진을 도입해야하나? 생각했지만, 간단한 검색을 위해 과하다는 생각도 들고 시간과 비용이 너무 많이 들 것 같아 고민이 됐다.  
  
### Full-Text Search Index
  
알고보니 이럴 때 사용할 수 있는 Full-Text Search 방식이 있었다.  
  

[//]: # (full-text에 대해 잘 설명되어 있는 글 - https://www.essential2189.dev/db-performance-fts)
[//]: # (인덱스 타입 - BTREE, FULLTEXT, HASH, RTREE | https://www.fun-coding.org/mysql_advanced5.html#gsc.tab=0)

### 성능 테스트

nGrinder를 이용해 대상 API에 대해 부하 테스트를 진행해봤다.  
  
- DB 데이터 1만 건
- VUser 500명
- 20분간 수행
- 
#### 개선 전

![img.png](img/Full-Text%20Search로%20TPS%20개선하기_img4.png)  
  
어떤 단어로 검색하느냐에 따라 차이가 있었지만, 대체로 평균 TPS 30 ~ 45 사이의 성능을 보였다.  

  


개발자 커뮤니티 대시보드 프로젝트에서 사용자의 질문을 검색하는 API를 구현하였습니다. 당시, 검색어 조건을 'like'문과 와일드카드를 사용하여 검색 쿼리를 작성하였습니다. 하지만, 이러한 쿼리는 인덱스를 사용하지 않아 성능이 좋지 않다는 것을 알게 되었습니다.
쿼리 개선 방법을 조사해본 결과, MySql에서 제공하는 Full-Text Search를 활용한 방법을 알게 되었습니다. 이를 활용하기 위해 먼저, Full-Text Search로 활용할 인덱스를 생성하였습니다. 이후 JPA 대신 Native 쿼리를 사용하여 match, against 구문을 사용해 조건절을 작성하였습니다.
이후 약 5만건의 데이터, 500명의 유저로 각각 30분간 테스트해본 결과, 평균 TPS가 36.6에서 313.1로 향상할 수 있었습니다.

![img.png](img/Full-Text%20Search로%20TPS%20개선하기_img2.png)  
  
  
![img.png](img/Full-Text%20Search로%20TPS%20개선하기_img3.png)  

### 인덱스 생성 파서

built-in, n-gram

### boolean mode, natural language mode

[//]: # (built-in 으로 생성해서 생긴 문제점.)
