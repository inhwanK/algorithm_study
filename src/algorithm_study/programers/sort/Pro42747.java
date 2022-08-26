package algorithm_study.programers.sort;

import java.util.Arrays;

// H-index - https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class Pro42747 {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations); // 0, 1, 3, 5, 6

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}

class Pro42747Answer {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for (int i = citations.length - 1; i > -1; i--) {
            int min = (int) Math.min(citations[i], citations.length - i);
            if (max < min) max = min;
        }

        return max;
    }
}