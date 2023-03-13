package algorithm_study.programers.level2;

import java.util.*;
// 롤케이크 자르기 - https://school.programmers.co.kr/learn/courses/30/lessons/132265
public class Pro132265 {
    public int solution(int[] topping) {
        int answer = 0;

        HashSet<Integer> leftSet = new HashSet();
        HashSet<Integer> rightSet = new HashSet();

        int size = topping.length;

        int[][] dp = new int[size][2];
        for (int i = 0; i < size; i++) {
            leftSet.add(topping[i]);
            rightSet.add(topping[size - i - 1]);

            dp[i][0] = leftSet.size();
            dp[size - i - 1][1] = rightSet.size();
        }

        for (int i = 0; i < size - 1; i++) {
            if (dp[i][0] == dp[i + 1][1]) {
                answer++;
            }
        }


        return answer;
    }
}
