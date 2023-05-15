package algorithm_study.programers.level3;

import java.util.*;

// 합승 택시 요금 - https://school.programmers.co.kr/learn/courses/30/lessons/72413
public class Pro72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int m = 20000001;

        int[][] total = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(total[i], m);
            total[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            for (int j = 0; j < 3; j++) {
                int start = fares[i][0];
                int end = fares[i][1];

                total[start][end] = fares[i][2];
                total[end][start] = fares[i][2];
            }
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    total[i][j] = Math.min(total[i][j], total[i][k] + total[k][j]);
                }
            }
        }

        int answer = total[s][a] + total[s][b];

        for (int i = 1; i < n + 1; i++) {
            answer = Math.min(answer, total[s][i] + total[i][a] + total[i][b]);
        }

        return answer;
    }
}
