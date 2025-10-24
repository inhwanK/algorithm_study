package algorithm_study.leetcode.medium;

// 2369. Check if There is a Valid Partition For The Array - https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2369 {
    boolean result = false;

    public boolean validPartition(int[] nums) {

        // dfs가 된다면 dp도 생각해보자.
        int size = nums.length;
        boolean[] dp = new boolean[size + 1];
        dp[0] = true;
        int left = 0;

        while (left < size + 1) {
            if (!dp[left]) {
                left++;
                continue;
            }

            if (valid1(left, nums)) {
                dp[left + 2] = true;
            }
            if (valid2(left, nums) || valid3(left, nums)) {
                dp[left + 3] = true;
            }

            left++;
        }


        return dp[size];
    }

    private boolean valid1(int index, int[] nums) {
        if (index + 1 >= nums.length) {
            return false;
        }
        if (nums[index] != nums[index + 1]) {
            return false;
        }
        return true;
    }

    private boolean valid2(int index, int[] nums) {
        if (index + 2 >= nums.length) {
            return false;
        }
        if (nums[index] != nums[index + 1] || nums[index + 1] != nums[index + 2]) {
            return false;
        }
        return true;
    }

    private boolean valid3(int index, int[] nums) {
        if (index + 2 >= nums.length) {
            return false;
        }
        if (nums[index] + 1 != nums[index + 1] || nums[index + 1] + 1 != nums[index + 2]) {
            return false;
        }
        return true;
    }
}
