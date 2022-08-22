package algorithm_study.leetcode.leetcode75;

// Find Pivot Index - https://leetcode.com/problems/find-pivot-index/
public class Leet724 {
    public int pivotIndex(int[] nums) {
        int right = 0;
        for(int i = 1; i < nums.length; i++) {
            right += nums[i];
        }

        int left = 0;
        if(right == left) return 0;
        for(int i = 1; i < nums.length; i++) {
            left += nums[i - 1];
            right -= nums[i];
            if(right == left) {
                return i;
            }
        }
        return -1;
    }
}

// 코드가 더 간결해진 듯
class Leet724Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}