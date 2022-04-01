package algorithm_study.mogakco.heap.practice;

public class Heap {

    final int size = 101;
    int[] arr = new int[size];
    int heapCount = 0;

    boolean compareWithParent(int insertIdx) {
        if (insertIdx <= 1) {
            return false;
        }

        int parent = insertIdx / 2;
        if (arr[insertIdx] < arr[insertIdx]) {
            return true;
        } else {
            return false;
        }
    }

    void insert(int data) {
        heapCount += 1;

        if (heapCount == 1) {
            arr[heapCount] = data;
            return;
        }

        arr[heapCount] = data;

        int insertIdx = heapCount;
        while (compareWithParent(insertIdx)) {

            int parent = insertIdx / 2;
            int temp = arr[insertIdx];
            arr[insertIdx] = arr[parent];
            arr[parent] = temp;

            insertIdx = parent;
        }
        return;
    }

    int pop() {
        int index = 1, childIndex, root, terminal_data, tmp;
        root = this.arr[1];
        terminal_data = this.arr[this.heapCount];
        this.arr[this.heapCount] = -1;
        this.arr[1] = terminal_data;
        this.heapCount--;

        while (true) {
            childIndex = compareWithChild(index);
            if (childIndex == 0) {
                break;
            }

            tmp = this.arr[childIndex];
            this.arr[childIndex] = this.arr[index];
            this.arr[index] = tmp;

            index = childIndex;
        }
        return root;
    }

    int compareWithChild(int insertIdx) {
        int leftChild = insertIdx * 2;
        int rightChild = insertIdx * 2 + 1;

        if (leftChild >= this.heapCount && rightChild >= this.heapCount) {
            return 0;
        }

        if (rightChild >= this.heapCount) {
            if (this.arr[leftChild] < this.arr[insertIdx]) {
                return leftChild;
            }

        }

        if (arr[leftChild] < arr[rightChild]) {
            return leftChild;
        } else {
            return rightChild;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.insert(1);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);
        heap.insert(10);
        heap.insert(11);
        heap.insert(2);


        for (int i = 1; i < 12; i++) {
            System.out.println(heap.arr[i]);
        }

    }
}