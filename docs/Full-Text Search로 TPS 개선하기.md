## Full-Text Search로 TPS 개선하기

과거에 진행했던 프로젝트에 리팩토링을 진행하면서 검색 쿼리의 성능을 개선해보았다.  
  
### 인덱스를 쓰지 않는 쿼리
  
개선 대상은 특정 키워드로 게시글을 조회하는 쿼리다. 이 쿼리는 where 절에 like 문과 '%키워드%' 형태로 조건이 걸려 있었다.  
이런 방식의 쿼리는 인덱스를 쓰지 않는 풀 테이블 스캔을 해 개선점이 있을거라 판단했다.  
  
![img.png](img/Full-Text%20Search/Full-Text%20Search로%20TPS%20개선하기_img1.png)  
- type 값이 ALL, 즉 풀 테이블 스캔  

당연히 개선 방법으로 인덱스 사용이 가장 먼저 떠올랐지만, 한편으론 무수히 많은 문자열 조합이 가능한 TEXT 데이터에 인덱스를 생성하는 것이 가능할까? 하는 의문도 들었다.  
그러면 어쩔 수 없이 검색 엔진을 도입해야하나? 생각도 했지만, 간단한 검색 기능일 뿐인데 과하다는 생각도 들고 시간과 비용이 너무 많이 들 것 같아 고민이 됐다.  

조금 조사해보니 이럴 때 사용하는 Full-Text Search 인덱스란게 존재했다.

### Full-Text Search Index
  
텍스트 데이터 특성상 부분 분자열이나 단어 단위의 검색이 필요한데, Full-Text 인덱스는 이를 위해 역인덱스 방식을 수행한다.
  
먼저 데이터를 단어나 형태소 단위로 분리하고, 이렇게 분리된 단어를 키로 하여 해당 단어가 존재하는 레코드 위치 정보를 값으로 가지는 방식이다. 이를 통해 검색 속도 향상이 가능하다.
  
#### Full-Text 인덱스 생성 및 사용
  
```mysql
-- 생성
create fulltext index 인덱스명 on 테이블명(컬럼1, 컬럼2, ...);
```
  
  
```mysql
-- 사용
select 컬럼1, 컬럼2, ...
from 테이블명
where match(조건 컬럼) against('검색할 키워드');
```
- fulltext search는 match() against() 구문으로 사용  
  
  
![img.png](img/Full-Text%20Search/Full-Text%20쿼리%20실행계획.png)  
- 쿼리 수행 시, fulltext index 사용하는 것 확인  


### 성능 테스트

nGrinder를 이용해 테스트를 진행해봤다.  
  
- DB 데이터 1만 건
- VUser 500명
- 20분간 수행
  
#### 개선 전

![img.png](img/Full-Text%20Search/Full-Text%20Search로%20TPS%20개선하기_img4.png)  
  
어떤 단어로 검색하느냐에 따라 차이가 있었지만, 대체로 평균 TPS 30 ~ 40 사이의 성능을 보였다.  
  
#### 개선 후
  
![img.png](img/Full-Text%20Search/Full-Text%20TPS%20그래프.png)  
  
평균 TPS 313.1, 최대 TPS 432까지 측정됐다. 개선 전 대비 약 10배의 성능 향상이었다.    
  
  
  
생각보다 많은 차이를 보여서 놀랬다. 여러번 테스트 해봐도 비슷한 차이를 보여서 테스트의 문제는 아닌 것 같고, 다른 Full-Text 사례를 봐도 일반적인 TPS 개선 폭을 추정하기는 어려웠다.
  
만약 일반적인 경우에 비해 개선 폭이 높은 것이라면, 그 이유가 뭘지 나름대로 추측해봤다.  
  
- mockru 를 이용해서 더미 데이터를 삽입함, 텍스트 데이터에 비슷하거나 완전히 같은 단어가 많음  
- mysql built-in 파서로 인덱스를 생성됨, 이는 공백 기준으로 단어를 구분하여 인덱싱함  
  
따라서, 실제 텍스트 양에 비해 인덱싱할 데이터 양은 작아서 그런 것이 아닐까 짐작된다.  


#### 사실은...

앞서 개선 대상 쿼리는 like '%키워드%' 를 사용했다. 이는 키워드를 부분 문자열로 포함하는 모든 데이터를 검색하기 위함이었다.  
하지만, built-in 파서는 공백을 기준으로 분리하기 때문에, 하나의 완성된 단어나 어절 단위로 인덱싱된다. 따라서 부분 문자열로 검색을 하기 위해서는 다른 방식의 파서를 사용해야 한다. 성능이 개선된 건 맞지만, 기존 요구사항과는 다른 셈이다.  

이럴 때 built-in 파서 대신 n-gram 파서를 이용할 수 있다.  
  
### 파서에 따라 다른 인덱스 구현 방식
  
mysql은 full-text 인덱스를 생성할 때 사용되는 파서를 여러가지 제공하는데, 파서에 따라 인덱싱되는 데이터나 그 개수가 달라진다. 먼저, built-in 파서와 n-gram 파서를 비교해봤다.  
  
#### built-in

- 기본적으로 MySQL에 내장되어 있음
- 공백을 구분자로 사용하여 텍스트를 **단어 단위**로 분리해 인덱싱
  - ex) "나는 인환" => "나는", "인환"

#### n-gram
  
- 연속된 n개의 문자 또는 단어를 의미, 2-gram은 두 개의 연속된 문자 또는 단어를 나타냄
- 텍스트를 **n-gram 토큰**으로 분리하여 인덱싱
  - ex) n = 2 일때 "나는 인환" => "나는", "는 ", " 인", "인환"

따라서 n-gram은 일부 단어가 일치하는 경우에도 검색 결과를 반환하여 부분 문자열 검색에 유용하고, built-in은 단어 단위의 검색에 적합하다.  
- [mysql n-gram 파서 ](https://dev.mysql.com/doc/refman/8.0/en/fulltext-search-ngram.html)


#### n-gram 파서로 fulltext 인덱스 생성하기

```mysql
-- 생성
create fulltext index 인덱스명 on 테이블명(컬럼1, 컬럼2, ...) with parser ngram;
```
기존 fulltext 인덱스 생성 쿼리에 'with parser ngram'를 붙여 다시 생성한 뒤, 정상동작하는 것을 확인했다.  
  
  
처음엔 단순히 인덱스로 개선한번 해볼까? 정도의 시도였는데, 생각보다 공부할 꺼리가 많은 주제여서 깊은 공부가 되버렸다....


[//]: # (### boolean mode, natural language mode)
[//]: # (built-in 으로 생성해서 생긴 문제점.)
[//]: # (파서 관련 공식 문서 - https://dev.mysql.com/doc/refman/8.0/en/fulltext-search-ngram.html)
[//]: # (https://dev.mysql.com/doc/extending-mysql/8.0/en/plugin-types.html#full-text-plugin-type&#41;)
[//]: # (full-text에 대해 잘 설명되어 있는 글 - https://www.essential2189.dev/db-performance-fts)
[//]: # (인덱스 타입 - BTREE, FULLTEXT, HASH, RTREE | https://www.fun-coding.org/mysql_advanced5.html#gsc.tab=0)