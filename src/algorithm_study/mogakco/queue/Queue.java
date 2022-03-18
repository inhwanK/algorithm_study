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
        if (tail == queSize - 1) {
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

        if (!this.isFull()) {
            tail = tail + 1;
            queue[tail] = item;
            System.out.println("삽입");
            return;
        }
        System.out.println("큐에 더 이상 데이터를 넣을 수 없습니다.");
    }

    int dequeue() {
        if (!this.isEmpty()) {
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
