package algorithm_study.leetcode.medium;

// 983. Minimum Cost For Tickets - https://leetcode.com/problems/minimum-cost-for-tickets/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        boolean[] travel = new boolean[366];

        for (int d : days) travel[d] = true;

        for (int i = 1; i <= 365; i++) {
            if (!travel[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            int cost1 = dp[i - 1] + costs[0];
            int cost7 = dp[Math.max(0, i - 7)] + costs[1];
            int cost30 = dp[Math.max(0, i - 30)] + costs[2];

            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }

        return dp[days[days.length - 1]];
    }
}
