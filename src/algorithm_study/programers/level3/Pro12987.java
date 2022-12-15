package algorithm_study.programers.level3;

import java.util.*;

// 숫자 게임 - https://school.programmers.co.kr/learn/courses/30/lessons/12987
public class Pro12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int index = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < A.length; i++) {
            if(A[index] < B[i]) {
                index++;
                answer++;
            }
        }

        return answer;
    }
}
