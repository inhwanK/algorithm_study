package algorithm_study.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// 1679. Max Number of K-Sum Pairs - https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet1679 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;

        for (int x : nums) {
            int y = k - x;
            int c = cnt.getOrDefault(y, 0);
            if (c > 0) {
                ans++;
                if (c == 1) cnt.remove(y);
                else cnt.put(y, c - 1);
            } else {
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            }
        }
        return ans;
    }
}
