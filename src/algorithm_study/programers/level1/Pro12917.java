package algorithm_study.programers.level1;

import java.util.Arrays;

// 문자열 내림차순으로 배치하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12917
public class Pro12917 {
    public String solution(String s) {
        String answer = "";
        String[] input = s.split("");
        Arrays.sort(input);

        for (int i = input.length - 1; i >= 0; i--) {
            answer += input[i];
        }

        return answer;
    }

    public String solution_answer(String str){
        char[] sol = str.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).reverse().toString();
    }
}
