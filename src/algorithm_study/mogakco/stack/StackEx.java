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
        if (isFull()) {
            System.out.println("스택이 가득 찼습니다.");
        } else {
            top = top + 1;
            arr[top] = item;
            System.out.println(arr[top] + "");
        }
    }

    boolean isEmpty() {
        if (top < 0) {
            return true;
        }
        return false;
    }

    Integer pop() {
        if (isEmpty()) {
            System.out.println("데이터가 없습니다.");
        } else {
            System.out.println("추출 값 : " + arr[top]);
            return arr[top--];
        }

        return null;
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

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println();
    }
}