package algorithm_study.leetcode.algorithm;

// Search Insert Position - https://leetcode.com/problems/search-insert-position/
public class Leet35 {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target) return i;
        }
        return nums.length;
    }
}
