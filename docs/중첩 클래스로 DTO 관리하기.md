## 중첩 클래스로 DTO 관리하기

최근 프로젝트 리팩토링을 진행하면서 DTO 클래스가 많아 관리에 어려움을 겪었다.  

### 문제 상황
- 엔터티 속성 중 일부를 나타내는 VO 클래스에 새로운 속성이 추가됨
- 엔터티 변경에 비해 많은 DTO 및 DTO assembler의 변경이 요구됨
- 많고 분산되어 있는 DTO, 가독성이 떨어지고 관리가 어려운 문제 발생
  - 비슷하고 중복된 필드가 많아 실수도 잦음
  
  
![img.png](img/중첩 클래스로 DTO 관리하기_img1.png)  
![img.png](img/중첩 클래스로 DTO 관리하기_img2.png)  
  
  
엔터티 변경에 비해 DTO 변경이 많이 요구되는 것은 의존성을 제대로 분리해주지 못한 탓이기도 하겠지만  
결정적으로 위 목록만 봤을 때 어떤 클래스에 변경이 필요한지 알아차리기 쉽지 않았고, 변경을 위해 확인해야하는 파일들이 많아 자꾸만 실수가 나왔다.  
따라서, 의존성 분리와 함께 DTO를 한눈에 알아보기 쉽도록 개선할 필요성을 느꼈다.  
이런 문제를 나만 경험하진 않았을 거라 생각해서 리서치 해봤더니, 중첩 클래스를 활용한 사례를 쉽게 볼 수 있었다.  
  
[//]: # (특히 VO 클래스 @Embeddable를 붙여 엔터티 속성 일부를 나타낼 때, `Question` 엔터티에 필드를 새롭게 추가해야하는 상황이 생겼다.  )

[//]: # (기존에는 질문의 내용을 `questionContents` 필드 하나로 표현했다면, `questionGeneral`, `questionError`, `questionCode` 로 좀 더 세분화해서 관리하려는 의도였다.  )

[//]: # (해당 필드는 VO 클래스를 통해 Embed 되어있는 상태였는데,   )

```java
@Embeddable
public class QuestionContents {

    public static final int MAXIMUM_CONTENT_LENGTH = 100000;

    @Column(name = "qs_contents", columnDefinition = "text", nullable = false)
    private String queContents;

    protected QuestionContents() {
    }

    public QuestionContents(String queContents) {
        validateNullContents(queContents);
        validateEmptyContents(queContents);
        validateMaximumLength(queContents);
        this.queContents = queContents;
    }
    
    // 생략
}

```
