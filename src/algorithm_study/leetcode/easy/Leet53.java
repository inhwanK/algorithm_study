package algorithm_study.leetcode.easy;

// Maximum Subarray - https://leetcode.com/problems/maximum-subarray/?envType=study-plan&id=data-structure-i
public class Leet53 {
    public int maxSubArray(int[] nums) {
        // Kadane's algorithm (카데인의 알고리즘)
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
