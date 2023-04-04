package algorithm_study.leetcode.medium;

import java.util.*;

// 75. Sort Colors - https://leetcode.com/problems/sort-colors/?envType=study-plan&id=data-structure-ii
public class Leet75 {
    public void sortColors(int[] nums) {
        // in-place?
        int index = 0;

        PriorityQueue<Integer> heap = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }

        while (!heap.isEmpty()) {
            nums[index++] = heap.poll();
        }
    }
}
