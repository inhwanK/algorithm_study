package algorithm_study.mogakco.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Quiz9_3 {

    private final int DUTY_TIME = 50;
    private final int REST_TIME = 10;

    private final int QUEUE_SIZE = 50;

    int[] queue;

    public Quiz9_3() {
        this.queue = new int[QUEUE_SIZE];
    }

    int total = 0;
    int dutySum = 0;
    int tail = 0;

    boolean overTime(int time) {

        if (tail + time < DUTY_TIME) {
            return false;
        }
        System.out.println("overTime");
        return true;
    }

    void onDuty(int id, int time) {

        if (!overTime(time)) {

            System.out.print(" " + id);
//            tail = (tail + 1) % QUEUE_SIZE;
            for (int i = 0; i < time; i++) {
                tail += i;
                total += 1;
                queue[tail] = id;
            }
        } else {
            tail = -1;
            total += 10;
            return;
        }
        System.out.print(",");
        System.out.println();
    }
    // 업무시간을 더 하면서 DUTY 보다 큰지 판별
    // 크다면 데이터를 모두 추출
    // 크지않으면 Queue로 삽입.

    // 큐를 모두 비우게 되면
    // 10분의 쉬는 시간 +


}

class QuizMain {
    public static void main(String[] args) {
        int[][] inquiry = {{1, 30}, {2, 20}, {5, 23}, {3, 40}, {9, 1}, {8, 50}, {7, 13}};

        Quiz9_3 quiz = new Quiz9_3();
        quiz.onDuty(1, 30);
        quiz.onDuty(2, 20);
        quiz.onDuty(5, 23);
        quiz.onDuty(3, 40);
        quiz.onDuty(9, 1);
        quiz.onDuty(8, 50);
        quiz.onDuty(7, 13);

        System.out.println("총 소요시간 : " + quiz.total);
    }
}
/*

public class QueueCustomer {

    static int[][] customer = {
            */
/*아이디, 예상처리시간*//*

            {1, 30}
            , {2, 20}
            , {5, 23}
            , {3, 40}
            , {9, 1}
            , {8, 50}
            , {7, 13}
    };
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
        return tail >= customer.length -1;
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
            if (work - queue[head+1] < queue[head+2]) {
                rest += 10;
                System.out.println("");
            }
            work -= queue[head+1];
            total += dequeue();
            System.out.print(customer[head-1][0] + " ");

            if (work < 0) work = 50;
        }
        System.out.println("\n총 소요 시간: " + (rest + total));
    }

}*/
