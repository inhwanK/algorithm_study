package algorithm_study.leetcode.easy;

// 1748. Sum of Unique Elements - https://leetcode.com/problems/sum-of-unique-elements/description/
public class Leet1784 {
    public int sumOfUnique(int[] nums) {
        int[] countArr = new int[101];
        for(int i = 0; i < nums.length; i++) {
            countArr[nums[i]]++;
        }

        int result = 0;
        for(int i = 0; i < countArr.length; i++) {
            if(countArr[i] == 1) {
                result += i;
            }
        }
        return result;
    }
}
