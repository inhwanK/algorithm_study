package algorithm_study.leetcode.medium;

import java.util.*;

// 2817. Minimum Absolute Difference Between Elements With Constraint - https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2817 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        if (x == 0) return 0;

        TreeSet<Integer> set = new TreeSet();
        int ans = Integer.MAX_VALUE;

        for (int i = x; i < n; i++) {
            set.add(nums.get(i - x));

            int cur = nums.get(i);

            Integer lo = set.floor(cur);
            if (lo != null) ans = Math.min(ans, cur - lo);

            Integer hi = set.ceiling(cur);
            if (hi != null) ans = Math.min(ans, hi - cur);

            if (ans == 0) return 0;
        }

        return ans;
    }
}
