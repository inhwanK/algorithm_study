package algorithm_study.leetcode.medium;

// Closest Dessert Cost - https://leetcode.com/problems/closest-dessert-cost/description/
public class Leet1774 {
    int result;
    int target;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.result = baseCosts[0];
        this.target = target;

        for (int baseCost : baseCosts) {
            dfs(baseCost, 0, toppingCosts);
        }
        return result;
    }

    private void dfs(int nowT, int toppingIndex, int[] toppingCosts) {
        if (Math.abs(target - nowT) < Math.abs(target - result) ||
                (Math.abs(target - nowT) == Math.abs(target - result) && nowT < result)) {
            result = nowT;
        }

        if (nowT > target || toppingIndex >= toppingCosts.length) {
            return;
        }
        int toppingCost = toppingCosts[toppingIndex];

        dfs(nowT, toppingIndex + 1, toppingCosts);
        dfs(nowT + toppingCost, toppingIndex + 1, toppingCosts);
        dfs(nowT + 2 * toppingCost, toppingIndex + 1, toppingCosts);
    }
}
