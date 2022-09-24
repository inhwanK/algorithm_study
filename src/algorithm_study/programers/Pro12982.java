package algorithm_study.programers;

import java.util.Arrays;

// 예산 - https://school.programmers.co.kr/learn/courses/30/lessons/12982
public class Pro12982 {
    public int solution(int[] d, int budget) {
        int answer = d.length;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
            budget -= d[i];
            if(budget < 0) {
                return i;
            }
        }
        return answer;
    }
}
