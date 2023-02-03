## ArrayList에 요소가 추가되는 과정 살펴보기

최근 배열에 대해 복습하면서 `ArrayList`에 대해 잘못 이해하고 있었다는 것을 깨달았다.
배열은 정적 배열과 동적 배열로 나뉘는데, 간략히 정리하면 다음과 같다.

### 배열
- 연속된 메모리 공간에 위치한 같은 타입 요소들의 모음
- 숫자 인덱스를 통한 랜덤 접근 가능
- 참조 O(1), 탐색 O(n)

#### 정적 배열
- 크기가 고정된 배열

#### 동적 배열
- 동적으로 요소 할당이 가능한 배열
- `Java`는 `ArrayList` 있다. **요소를 추가할 때 기존 저장 용량을 초과하면 자동으로 용량이 늘어남**


지금까지는 `ArrayList`도 `LinkedList`처럼 요소가 포인터로 연결된 형태라고 생각해왔다.  
같은 `List`타입인데다가 중간 삽입/삭제 등의 api가 제공되는 것이 이유였다. (api를 제공한 것이지 내부 동작은 그렇지 않을 수 있다는 생각을 못했다...)  

결론은 `ArrayList`도 배열이었다. 정확히는 정적 배열을 가져서 동적 배열로 사용된다.  
동적으로 크기가 변할 뿐인거지 연속된 메모리 공간, 랜덤 접근 등 주요한 특징은 연결리스트가 아니라 배열이다.   

앞서 정리한 대로 `ArrayList`가 동적 배열이 맞다면, 요소 추가 메서드에 배열 크기 비교 및 증가 로직이 포함 될 것이라 추측했다.

### ArrayList 상위 클래스들

`ArrayList`는 `add(E e)`메서드를 통해 요소를 추가한다. 해당 로직을 찾기위해 `add(E e)`가 추가된 가장 상위 계층부터 살펴봤다.
 
<img src="img/ArrayList Diagram.png" width="700">


`Collection`인터페이스부터 `add(E e)` 메서드가 추가된다. `Collection`을 자식들은 모두 `add(E e)` 메서드를 가져야 한다는 건데  
`Collection`의 자식인 `List`, `AbstractList`를 봤더니 최근 이펙티브 자바에서 학습한 골격 구조로 된 것임을 파악했다. (아는거 나와서 반가웠다..)

다이어그램만 봤을 때는 `ArrayList`외에도 `AbstractList`를 상속하는 동적 배열이 존재할 것이기 때문에, 어쩌면 `AbstractList`에 이미 배열 크기를 늘리는 로직이 구현되어 있을 수 있다고 생각했다.


### `add(E e)` 메서드

#### `AbstractList`의 `add(E e)`

```java
// AbstractList

public boolean add(E e) {
    add(size(), e);
    return true;
}

public void add(int index, E element) {
    throw new UnsupportedOperationException();
}
```

확인해보니 실제로는 무조건 `UnsupportedOperationException()`을 던진다. 동적인 요소 추가를 지원하지 않는 구현체를 고려한 것 같다.   


#### `ArrayList`의 `add(E e)`
```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}

```

`ArrayList`를 살펴본 결과, 공통적으로 `ensureCapacityInternal(int minCapacity)` 메서드를 호출한다.  
이름부터 배열 용량에 관한 메서드임을 암시한다. 꽤 돌아오긴 했지만 배열 용량에 관한 로직을 찾아냈다.  

### `ArrayList`가 배열의 크기를 늘리는 과정 

#### 기존 크기와 필요한 배열 크기 비교

```java

private static int calculateCapacity(Object[] elementData, int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        return Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    return minCapacity;
}

private void ensureCapacityInternal(int minCapacity) {
    ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
}

private void ensureExplicitCapacity(int minCapacity) {
    modCount++;

    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}

```

- `초기 배열 길이`와 `확보되어야 하는 길이`를 비교해 더 큰 값을 반환
  - 현재 배열이 초기 배열과 다르다면, 비교하지 않고 바로 `확보되어야 하는 길이`를 반환함  
- 반환 받은 값과 현재 배열의 크기를 비교
- 반환 값이 더 클 경우, 배열 길이를 늘리는 로직이 수행됨 `grow(int minCapacity)`
  
  
#### 배열 복사 및 크기 확장
  
`grow(int minCapacity)` 내부를 보면 새로운 크기로 배열을 복사하는 것이 확인된다.  
가장 밑에 `elementData = Arrays.copyOf(elementData, newCapacity);` 부분이다.
  
```java
private void grow(int minCapacity) {
      // overflow-conscious code
      int oldCapacity = elementData.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      if (newCapacity - minCapacity < 0)
          newCapacity = minCapacity;
      if (newCapacity - MAX_ARRAY_SIZE > 0)
          newCapacity = hugeCapacity(minCapacity);
      // minCapacity is usually close to size, so this is a win:
      elementData = Arrays.copyOf(elementData, newCapacity);
  }
```
  
#### 배열 맨 뒤 삽입과 중간 삽입의 차이
  
`add(E e)` 는 요소를 맨 뒤에 삽입하기에 배열의 크기를 확장해주기만 하면 되지만,  
`add(int index, E element)`는 중간에 요소를 추가하는 것이므로 추가된 인덱스 뒤의 요소들을 옮겨주는 과정이 필요하다.  
  
```java
public void add(int index, E element) {
    rangeCheckForAdd(index);

    ensureCapacityInternal(size + 1);  // Increments modCount!!
    System.arraycopy(elementData, index, elementData, index + 1,
                     size - index);
    elementData[index] = element;
    size++;
}
```

`System.arraycopy(...)`를 통해 해당 작업을 수행하는 것을 확인할 수 있었다.  
다른 로직은 `add(E e)`랑 별다른 점은 없다.  

차이는 맨 뒤 삽입의 경우 O(1), 중간 삽입은 배열을 복사하는 과정 때문에 O(n)의 시간복잡도를 가진다는 점이다.  
`ArrayList` 사용할 때 주의해야 할 점이겠다.
  
### 정리

- `ArrayList`는 **동적 배열**이다.
  - 따라서 배열과 같은 특징을 가진다.
- 배열 크기를 초과하는 삽입 요청은 성능에 영향을 끼칠 수 있다.
- 초기 배열 크기를 정하지 않고 사용 가능하다.

실제 반복문을 돌려보면서 배열의 크기가 어떻게 변화해나가는지 확인해볼 필요가 있겠다.