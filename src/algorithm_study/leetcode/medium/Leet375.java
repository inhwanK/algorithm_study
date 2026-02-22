package algorithm_study.leetcode.medium;

// 375. Guess Number Higher or Lower II - https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 2][n + 2];

        for (int len = 2; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;

                for (int k = l; k <= r; k++) {
                    int left = (k - 1 >= l) ? dp[l][k - 1] : 0;
                    int right = (k + 1 <= r) ? dp[k + 1][r] : 0;

                    int worst = k + Math.max(left, right);
                    dp[l][r] = Math.min(dp[l][r], worst);
                }
            }
        }
        return dp[1][n];
    }
}
