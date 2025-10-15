package algorithm_study.leetcode.medium;

import java.util.*;

// 132 Pattern - https://leetcode.com/problems/132-pattern/?envType=problem-list-v2&envId=vol6mrd1
public class Leet456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack();

        int two = -1000000001;
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];

            if (x < two) return true;

            while (!stack.isEmpty() && x > stack.peek()) {
                two = Math.max(two, stack.pop());
            }
            stack.push(x);
        }
        return false;
    }
}
