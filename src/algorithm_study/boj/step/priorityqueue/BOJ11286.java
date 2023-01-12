package algorithm_study.boj.step.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> heap = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (Math.abs(o2) == Math.abs(o1)) {
                    return (int) (o1 - o2);
                }
                return (int) (Math.abs(o1) - Math.abs(o2));
            }
        });

        for (int i = 0; i < n; i++) {
            long target = Long.parseLong(br.readLine());
            if (target == 0) {
                if (heap.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(heap.poll());
                continue;
            }

            heap.add(target);
        }
    }
}
