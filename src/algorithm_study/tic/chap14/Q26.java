package algorithm_study.tic.chap14;

import java.util.PriorityQueue;
import java.util.Scanner;

// 카드 정렬하기 (큐와 힙 공부 더하기)
public class Q26 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        PriorityQueue<Integer> cardHeap = new PriorityQueue();

        for (int i = 0; i < N; i++) {
            cardHeap.offer(sc.nextInt());
        }

        int result = 0;
        while (cardHeap.size() != 1) {
            int sum = cardHeap.poll() + cardHeap.poll();
            cardHeap.offer(sum);
            result += sum;

        }

        System.out.println(result);
    }
}
