package algorithm_study.programers.level1;

import java.util.Arrays;

// 문자열 내 마음대로 정렬하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class Pro12915 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            answer[i] = strings[i].charAt(n) + " " + strings[i];
        }

        Arrays.sort(answer);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer[i].substring(2);
        }
        return answer;
    }
}
