package algorithm_study.leetcode;

// Binary Search - https://leetcode.com/problems/binary-search/
public class Leet704 {
    // solution이랑 동일
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int index = (left + right) / 2;
            if (nums[index] == target) return index;
            if (nums[index] < target) {
                left = index + 1;
            }
            if (nums[index] > target) {
                right = index - 1;
            }
        }
        return -1;
    }
}
