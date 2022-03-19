package algorithm_study.mogakco.stack;

public class StackEx {

    final int MAX = 3;
    int[] arr;
    int top = -1;

    public StackEx() {
        this.arr = new int[MAX];
    }

    boolean isFull() {
        if (top == 2) {
            return true;
        }
        return false;
    }

    void push(int item) {
        if (!isFull()) {
            arr[top + 1] = item;
            return;
        } else {
            System.out.println("스택이 가득 찼습니다.");
        }
    }

}

class StackMain {
    public static void main(String[] args) {

        StackEx stack = new StackEx();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(1);
        System.out.println();
    }
}