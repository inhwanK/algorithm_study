package algorithm_study.programers.level2;

import java.util.PriorityQueue;

// 더 맵게 - https://school.programmers.co.kr/learn/courses/30/lessons/42626
public class Pro42626 {
    class Scoville implements Comparable<Scoville> {
        Integer k;

        public Scoville(Integer k) {
            this.k = k;
        }

        public int compareTo(Scoville o) {
            return this.k.compareTo(o.k);
        }
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Scoville> heap = new PriorityQueue();

        for (Integer s : scoville) {
            Scoville scov = new Scoville(s);
            heap.add(scov);
        }

        Scoville now = heap.peek();
        int count = 0;
        while (now.k < K) {
            if (heap.size() < 2) {
                return -1;
            }

            Scoville first = heap.poll();
            Scoville second = heap.poll();

            int sum = first.k + (second.k * 2);

            Scoville newScov = new Scoville(sum);
            heap.add(newScov);

            now = heap.peek();
            count++;
        }
        answer = count;
        return answer;
    }
}

class Pro42626Answer {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int count = 0;
        while (q.size() > 1 && q.peek() < K) {
            int weakHot = q.poll();
            int secondWeakHot = q.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            q.add(mixHot);
            count++;
        }

        if (q.size() <= 1 && q.peek() < K)
            count = -1;

        return count;
    }
}