package algorithm_study.programers.level1;

import java.util.PriorityQueue;

// 명예의 전당 (1) - https://school.programmers.co.kr/learn/courses/30/lessons/138477
public class Pro138477 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> heap = new PriorityQueue();

        int now = 101;
        for (int i = 0; i < score.length; i++) {
            heap.add(score[i]);
            if (heap.size() > k) {
                heap.poll();
            }

            answer[i] = heap.peek();
        }

        return answer;
    }
}
