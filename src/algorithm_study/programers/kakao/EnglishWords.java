package algorithm_study.programers.kakao;

// 숫자 문자열과 영단어
// https://programmers.co.kr/learn/courses/30/lessons/81301
public class EnglishWords {
    public int solution(String s) {
        int answer = 0;

        String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i = 0; i < numbers.length;i++){
            s = s.replace(numbers[i], i+"");
        }
        answer = Integer.parseInt(s);

        return answer;
    }
}
