## 중첩 클래스로 DTO 관리하기

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
이러한 문제를 해결하기 위해 나름대로 조사해봤더니 중첩 클래스를 활용한 사례를 쉽게 찾아볼 수 있었다.  
  
### 클래스 내부에 DTO 옮기기
  
![img.png](img/중첩%20클래스로%20DTO%20관리하기_img3.png)  
- 줄어든 목록  
  
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
  


### 중첩 클래스

그냥 클래스 내부로 DTO를 옮기기만 하면 되는 걸까?  일단 옮기
