package algorithm_study.leetcode.medium;

import java.util.*;

// Daily Temperatures - https://leetcode.com/problems/daily-temperatures/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<int[]> deq = new ArrayDeque();
        for (int i = 0; i < temperatures.length; i++) {
            int x = temperatures[i];
            while (!deq.isEmpty() && deq.peekFirst()[0] < x) {
                int[] d = deq.pollFirst();
                answer[d[1]] = i - d[1];
            }
            deq.addFirst(new int[]{x, i});
        }

        return answer;
    }
}
