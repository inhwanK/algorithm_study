package algorithm_study.mogakco.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Quiz9_3 {

    static int[][] customer = {{1, 30}, {2, 20}, {5, 23}, {3, 40}, {9, 1}, {8, 50}, {7, 13}};
    static int[] queue = new int[10];
    static int head = 0;
    static int tail = 0;

    public static void main(String[] args) {
        for (int i = 0; i < customer.length; i++) {
            enqueue(customer[i][1]);
        }
        work();
    }

    static boolean isEmpty() {
        return head == tail;
    }

    static boolean isFull() {
        return tail >= customer.length - 1;
    }

    static void enqueue(int item) {
        if (isFull()) {
            System.out.println("큐에 더이상 데이터를 넣을 수 없습니다.");
            return;
        }
        tail = (tail + 1) % customer.length;
        queue[tail] = item;
    }

    static int dequeue() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다.");
            return -1;
        }
        head = (head + 1) % customer.length;
        return queue[head];
    }

    static void work() {
        int total = 0;
        int work = 50;
        int rest = 0;

        while (!isEmpty()) {
            if (work - queue[head + 1] < queue[head + 2]) {
                rest += 10;
                System.out.println("");
            }
            work -= queue[head + 1];
            total += dequeue();
            System.out.print(customer[head - 1][0] + " ");

            if (work < 0) work = 50;
        }
        System.out.println("\n총 소요 시간: " + (rest + total));
    }
}