package algorithm_study.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

// Sliding Window Maximum - https://leetcode.com/problems/sliding-window-maximum/description/
public class Leet239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                System.out.println("peekFirst() : " + dq.peekFirst());
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                System.out.println("pollLast() : " + dq.pollLast());
            }

            System.out.println("i : " + i);
            dq.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
