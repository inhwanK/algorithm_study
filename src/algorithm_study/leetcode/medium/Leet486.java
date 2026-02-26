package algorithm_study.leetcode.medium;

// 486. Predict the Winner - https://leetcode.com/problems/predict-the-winner/description/
public class Leet486 {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                int takeLeft = nums[l] - dp[l + 1][r];
                int takeRight = nums[r] - dp[l][r - 1];
                dp[l][r] = Math.max(takeLeft, takeRight);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
