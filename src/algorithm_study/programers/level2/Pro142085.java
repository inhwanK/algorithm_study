package algorithm_study.programers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Pro142085 {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;

        PriorityQueue<Integer> heap = new PriorityQueue(Collections.reverseOrder());

        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            heap.add(enemy[i]);

            if (n < 0) {
                if (k > 0 && !heap.isEmpty()) {
                    n += heap.poll();
                    k--;
                } else {
                    answer = i;
                    break;
                }

            }
        }

        return answer;
    }
}
