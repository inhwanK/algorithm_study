package algorithm_study.leetcode.medium;

// 1027. Longest Arithmetic Subsequence - https://leetcode.com/problems/longest-arithmetic-subsequence/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet1027 {
    public int longestArithSeqLength(int[] nums) {
        int[][] dp = new int[nums.length][1001];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][nums[i] - nums[j] + 500] = dp[j][nums[i] - nums[j] + 500] + 1;
                max = Math.max(max, dp[i][nums[i] - nums[j] + 500]);
            }
        }
        return max + 1;
    }
}
