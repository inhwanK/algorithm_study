### ✅ 오늘의 문제: 데이터 삽입 구현하기

<br>
오늘은 그래프에 대해 배워봤습니다.

그래프를 설명하면서, 따로 코드를 작성하진 않았어요.

이건 전부 퀴즈를 위한 포석이였습니다. 😉

<br>
오늘 작성했던 배열을 사용한 그래프 표현에서,

데이터를 삽입하는 insert 함수를 구현해 주세요!

<br>
insert 함수는 간선이 나가는 노드 번호와 간선이 들어오는 노드 번호,

간선의 가중치와 방향그래프인지, 무방향 그래프인지 여부를 파라미터로 받아요!

<br>
<pre> insert(주는 노드, 받는 노드, 가중치, 무방향그래프 여부)</pre>

<br>
오늘 예제를 insert 함수로 호출하면 아래와 같겠네요. 😉

### 👉 예시 그래프

![Quiz14_2.png](Quiz14_2.png)

### 👉 데이터 삽입 호출

<pre>
insert(0, 1, 1, 1)
insert(0, 3, 1, 1)
insert(1, 2, 1, 1)
insert(1, 3, 1, 1)
insert(2, 3, 1, 1)
</pre>