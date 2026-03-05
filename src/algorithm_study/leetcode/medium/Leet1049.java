package algorithm_study.leetcode.medium;

// 1049. Last Stone Weight II - https://leetcode.com/problems/last-stone-weight-ii/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet1049 {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int x : stones) total += x;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int w : stones) {
            for (int s = target; s >= w; s--) {
                dp[s] = dp[s] || dp[s - w];
            }
        }

        for (int s = target; s >= 0; s--) {
            if (dp[s]) return total - 2 * s;
        }
        return total;
    }
}
