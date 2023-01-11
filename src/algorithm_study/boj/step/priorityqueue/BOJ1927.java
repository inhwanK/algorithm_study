package algorithm_study.boj.step.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙 - https://www.acmicpc.net/problem/1927
public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> heap = new PriorityQueue<>();

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
