package algorithm_study.programers.level2;

// 땅따먹기 - https://school.programmers.co.kr/learn/courses/30/lessons/12913
public class Pro12913 {
    int solution(int[][] land) {
        int answer = 0;

        int[][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k == j) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][k] + land[i][j], dp[i][j]);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(dp[land.length - 1][i], answer);
        }

        return answer;
    }
}
