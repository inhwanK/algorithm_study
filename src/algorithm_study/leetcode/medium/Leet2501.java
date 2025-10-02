package algorithm_study.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Longest Square Streak in an Array - https://leetcode.com/problems/longest-square-streak-in-an-array/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2501 {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add((long) nums[i]);
        }

        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            long cur = nums[i];
            int leng = 1;
            while (set.contains(cur * cur)) {
                cur = cur * cur;
                leng++;
            }

            max = Math.max(leng, max);
        }

        if (max == 1) {
            return -1;
        }
        return max;
    }


    public int longestSquareStreakRefactor(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int max = 1;

        for (int x : nums) {
            // 시작점 최적화 (optional)
            int root = (int) Math.sqrt(x);
            if (root * root == x && set.contains(root)) continue;

            long cur = x;
            int leng = 1;
            while (cur * cur <= Integer.MAX_VALUE && set.contains((int) (cur * cur))) {
                cur = cur * cur;
                leng++;
            }
            max = Math.max(max, leng);
        }

        return max == 1 ? -1 : max;
    }
}
