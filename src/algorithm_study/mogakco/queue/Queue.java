package algorithm_study.mogakco.queue;

public class Queue {

    private int queSize = 5;
    private int[] queue;
    private int head;
    private int tail;

    public Queue() {
        head = -1;
        tail = -1;
        queue = new int[queSize];
    }

    boolean isFull() {
        if (tail >= queSize - 1 && head == -1) {
            return true;
        }

        return false;
    }

    boolean isEmpty(){
        if(head == tail){
            return true;
        } else{
            return false;
        }

    }

    void enqueue(int item) {

        if (!isFull()) {
            tail = tail + 1;
            queue[tail] = item;
            System.out.println("삽입");
            return;
        }
        System.out.println("큐가 꽉 차 있습니다. ");
    }

    int dequeue() {
        if (head != tail) {
            head++;
            System.out.println("추출");
            return queue[head];
        }

        System.out.println("큐가 비어있습니다.");
        return -1;
    }
}

class Main{
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }
}
