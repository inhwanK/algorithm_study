package algorithm_study.programers.level3;

// 등교길 - https://school.programmers.co.kr/learn/courses/30/lessons/42898#
public class Pro42898 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1_000_000_007;

        int[][] dp = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                if (dp[i - 1][j] > 0) {
                    dp[i][j] += dp[i - 1][j] % mod;
                }

                if (dp[i][j - 1] > 0) {
                    dp[i][j] += dp[i][j - 1] % mod;
                }
            }
        }

        answer = dp[n][m] % mod;

        return answer;
    }
}
