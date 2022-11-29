package algorithm_study.programers.level3;

import java.util.PriorityQueue;

// 야근 지수 - https://school.programmers.co.kr/learn/courses/30/lessons/12927
public class Pro12927 {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue((o1, o2) -> Integer.compare((Integer) o2, (Integer) o1));

        for (int i = 0; i < works.length; i++) {
            heap.add(works[i]);
        }

        for (int i = 0; i < n; i++) {
            Integer target = heap.poll();
            if (target == 0) {
                heap.add(target);
                break;
            }

            target--;
            heap.add(target);
        }


        for (int i = 0; i < works.length; i++) {
            answer += Math.pow(heap.poll(), 2);
        }


        return answer;
    }
}
