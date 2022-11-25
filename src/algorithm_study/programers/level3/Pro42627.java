package algorithm_study.programers.level3;

import java.util.*;

// 디스크 컨트롤러 - https://school.programmers.co.kr/learn/courses/30/lessons/42627#
public class Pro42627 {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < jobs.length; i++) {
            System.out.println(jobs[i][0] + " " + jobs[i][1]);
        }

        int count = 0;
        int now = 0;

        int i = 0;
        while (count < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= now) {
                heap.add(jobs[i++]);
            }

            if (heap.isEmpty()) {
                now = jobs[i][0];
                continue;
            }

            int[] temp = heap.poll();
            answer += temp[1] + now - temp[0];
            now += temp[1];
            count++;

        }
        return answer / jobs.length;
    }
}
