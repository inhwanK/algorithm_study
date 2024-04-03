package algorithm_study.programers.level3;

import java.util.*;
// 입국 심사 - https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class Pro43238 {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long left = 0;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            if (sum < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }

        }
        return answer;
    }
}
