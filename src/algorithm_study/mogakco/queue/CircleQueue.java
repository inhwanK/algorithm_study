package algorithm_study.mogakco.queue;

public class CircleQueue {

    private int MAX_QUEUE_SIZE = 5;
    private int[] queue;
    private int head;
    private int tail;

    public CircleQueue() {
        head = -1;
        tail = -1;
        queue = new int[MAX_QUEUE_SIZE];
    }


    boolean isFull() {
        if ((tail + 1) % MAX_QUEUE_SIZE == head) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    void enqueue(int item) {

        if (!isFull()) {
//            tail = tail + 1;
            queue[(tail + 1) % MAX_QUEUE_SIZE] = item;
            System.out.println("삽입");
            return;
        }
        System.out.println("큐에 더 이상 데이터를 넣을 수 없습니다.");
    }

    int dequeue() {
        if (!isEmpty()) {
            head = (head + 1) % MAX_QUEUE_SIZE;
            System.out.println("추출");
            return queue[head];
        }

        System.out.println("큐가 비어있습니다.");
        return -1;
    }

}

class CircleQueueMain {
    public static void main(String[] args) {
        CircleQueue cirQueue = new CircleQueue();

        cirQueue.enqueue(1);
        cirQueue.enqueue(2);
        cirQueue.enqueue(3);
        cirQueue.enqueue(4);
        cirQueue.enqueue(5);


        cirQueue.dequeue();
        cirQueue.dequeue();
        cirQueue.dequeue();
        cirQueue.dequeue();
        cirQueue.dequeue();

        cirQueue.enqueue(1);
        cirQueue.enqueue(2);
        cirQueue.enqueue(3);
    }
}