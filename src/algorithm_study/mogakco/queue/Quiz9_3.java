package algorithm_study.mogakco.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Quiz9_3 {

    private final int DUTY_TIME = 50;
    private final int REST_TIME = 10;

    private final int QUEUE_SIZE = 60;
    int[] queue;

    public Quiz9_3(int[] queue) {
        this.queue = new int[QUEUE_SIZE];
    }

    int total;
    int dutySum;
    int tail = -1;

    boolean overTime() {

        return true;
    }

    void insert(int[][] arr, int item) {

        if (!overTime()) {
            tail = (tail + 1) % QUEUE_SIZE;
            queue[tail] = item;
        }
        return;
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
    }
}