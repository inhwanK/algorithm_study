package algorithm_study.leetcode.medium;

import java.util.*;

// 3Sum - https://leetcode.com/problems/3sum/description/
public class Leet15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet();

        for(int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int target = nums[i] + nums[left];
                if(target + nums[right] == 0) {
                    set.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if(target + nums[right] < 0) {
                    left++;
                } else if(target + nums[right] > 0) {
                    right--;
                }
            }
        }

        return new ArrayList(set);
    }
}
