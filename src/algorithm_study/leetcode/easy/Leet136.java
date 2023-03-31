package algorithm_study.leetcode.easy;

import java.util.*;

// 136. Single Number - https://leetcode.com/problems/single-number/description/?envType=study-plan&id=data-structure-ii
public class Leet136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) == 1) {
                result = num;
            }
        }
        return result;
    }


    public int singleNumberAnswer(int[] nums) {
        int ans = 0; //since XOR with 0 returns same number
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];  // ans = (ans) XOR (array element at i)
        }
        return ans;
    }
}
