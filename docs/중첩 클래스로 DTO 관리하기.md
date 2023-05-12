## 정적 멤버 클래스로 DTO 관리하기

최근 프로젝트 리팩토링을 진행하면서 DTO 클래스가 많아 관리에 어려움을 겪었다.

### 문제 상황

- 엔터티 속성 중 일부를 나타내는 VO 클래스에 새로운 속성이 추가됨
- 엔터티 변경에 따라 DTO 및 DTO assembler의 변경이 요구됨
- 많고 분산되어 있는 DTO, 가독성이 떨어지고 관리가 어려운 문제 발생
    - 비슷하고 중복된 필드가 많아 실수도 잦음

### 수 많은 DTO들
  
![img](img/중첩%20클래스로%20DTO%20관리하기_img1.png)  
![img](img/중첩%20클래스로%20DTO%20관리하기_img2.png)  
- 변경이 요구되는 파일을 모두 열어봐야하는 상태

```java

@Getter
public class BoardResponseDto {

    private Long boardIdx;
    private User author;
    private String boardTitle;
    private String boardContents;
    private String boardCategory;
    private Long boardViews;
    private Boolean boardLocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생략
}
```

- 막상 열어보면 수정해야할 코드도 많음  
  
엔터티 변경과 함께 DTO 변경도 요구되는 것은 의존성을 제대로 분리하지 못한 탓이지만, 그것과는 별개로 많은 수의 DTO 관리에도 불편함을 느꼈다. 
이를 해결하기 위해 나름대로 조사해봤더니 정적 멤버 클래스를 활용한 사례를 쉽게 찾아볼 수 있었다.  
  
### DTO를 정적 멤버 클래스로 바꾸기
  
정적 멤버 클래스는 중첩 클래스(클래스 내부에 선언된 클래스)의 한 종류로, 정적(static)으로 생성된 클래스를 말한다.  
여기서는 DTO 전체를 감쌀 `QuestionDto` 클래스를 선언하고, 내부에 `RequestDto`, `ResponseDto` 등 실제 DTO를 static으로 선언해 뒀다. 
이렇게 하면 `QuestionDto.RequestDto`, `QuestionDto.ResponseDto` 같은 형태로 원하는 DTO를 참조해 사용할 수 있다.  
  
```java
public class QuestionDto {

    @Getter
    @NoArgsConstructor
    public static class SaveRequestDto {

        private String queTitle;
        private String queGeneralContent;
        private String queCodeContent;
        private String queErrorContent;

        // 생략
    }

    @Getter
    @NoArgsConstructor
    public static class UpdateRequestDto {
        
        private Long queIdx;
        private String userEmail;
        private String queTitle;
        private String queGeneralContent;
        private String queCodeContent;
        private String queErrorContent;
        
        // 생략
    }


    @Getter
    public static class DetailResponseDto {

        private Long queIdx;
        private String userEmail;
        private String userNick;
        private List<AnswerResponse> answers;
        private String queTitle;
        private String queGeneralContent;
        private String queCodeContent;
        private String queErrorContent;
        private boolean queSolved;
        private boolean queLocked;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        
        // 생략
    }

    @Getter
    public static class ListResponseDto {

        private Long queIdx;
        private User questioner;
        private String queTitle;
        private QuestionContents queContents;
        private boolean queSolved;
        private boolean queEnabled;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        // 생략
    }
}
```
- `Question`에 관련된 DTO만 모여있는 QuestionDto 클래스

![img.png](img/중첩%20클래스로%20DTO%20관리하기_img3.png)
- 줄어든 목록
  
### 정적 멤버 클래스 좀 더 자세히 알아보기

#### 중첩 클래스의 종류

- 정적 멤버 클래스
- 비정적 멤버 클래스
- 익명 클래스
- 지역 클래스

위처럼 중첩 클래스는 정적 멤버 클래스를 포함해 네가지 종류가 있는데, 단순히 DTO 관리를 위한 것이라면 그 중 굳이 정적 멤버 클래스여야하는 이유가 있을까? 혹시 내가 모르는 다른 문제는 없을까?
  
<이펙티브 자바> 아이템 24 을 보면 각각의 차이를 자세히 설명해준다. 그 중에서도 비정적, 정적 멤버 클래스 간의 차이에서 근거를 찾을 수 있었다.  

#### 정적 멤버 클래스

- static 구문 포함
- 바깥 클래스와 함께 사용할 때만 유용한 public 도우미 클래스 역할
  - ex) `Calculator` 클래스의 public 정적 멤버 클래스로 `Operation` 열거 타입을 구현했다면 `Calculator.Operation.PLUS`, `Calculator.Operation.MINUS` 같은 형태로 참조 가능
- 중첩 인스턴스가 바깥 인스턴스 없어도 독립적으로 존재할 수 있음

#### 비정적 멤버 클래스
  
- static 구문 없음
- 바깥 인스턴스 없이는 중첩 인스턴스를 생성될 수 없음
  - 두 인스턴스 간의 관계가 중첩 인스턴스 안에 만들어져 메모리를 차지함


따라서, 멤버 클래스에서 바깥 인스턴스에 접근할 일이 없으면 무조건 static을 붙여 정적 멤버 클래스로 만들라고 말한다. 

이 글의 주제와 관련 있는 것은 정적, 비정적 멤버 클래스에 대한 차이에 주목했다.  
익명 클래스와 지역 클래스는
서로 관련있는 클래스를 묶기 위한 용도라면 다른 중첩 비정적 멤버 클래스를 사용


