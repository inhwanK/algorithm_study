package algorithm_study.programers.level1;

import java.util.*;

// 푸드 파이트 대회 - https://school.programmers.co.kr/learn/courses/30/lessons/134240
public class Pro134240 {
    public String solution(int[] food) {
        String answer = "";
        String reverse = "";

        for (int i = 1; i < food.length; i++) {
            int fc = food[i] / 2;
            for (int j = 0; j < fc; j++) {
                answer += i;
            }
        }

        answer += 0;
        for (int i = answer.length() - 2; i >= 0; i--) {
            reverse += answer.charAt(i);
        }
        answer += reverse;

        return answer;
    }

    public String solution1(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i;
            }
        }

        return answer;
    }
}
