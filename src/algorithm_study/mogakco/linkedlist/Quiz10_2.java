package algorithm_study.mogakco.linkedlist;

public class Quiz10_2 {

    public static void main(String[] args) {

        append(1);
        append(2);
        append(4);
        print_linked_list2();

        insert(10, 0);
        print_linked_list2();

        insert(20, 3);
        print_linked_list2();

        delete(1);
        print_linked_list2();

        delete(0);
        print_linked_list2();
    }

    static Node head = new Node(null);

    static Node get(int index) {

        while (true) {
            Node node = head.nextPointer;

            if (index == 0) {
                return node;
            }

            if (node == null) {
                System.out.println("Index Error");
                return null;
            }

            node = node.nextPointer;
            index--;
        }
    }

    static void insert(Object data, int index) {
        Node node = head.nextPointer;
        Node newNode = new Node(data);

        while (true) {
            if (node == null) {
                System.out.println("Index Error");
                return;
            }

            if (index == 0) {

                newNode.prePointer = node.prePointer;
                newNode.nextPointer = node;

                node.prePointer.nextPointer = newNode;
                node.prePointer = newNode;

                return;
            }

            node = node.nextPointer;
            index--;
        }
    }

    static void append(Object data) {
        Node node = head.nextPointer;
        Node newNode = new Node(data);

        if (head.nextPointer == null) {
            head.nextPointer = newNode;
            newNode.prePointer = head;
            return;
        }

        while (true) {
            if (node.nextPointer == null) {
                node.nextPointer = newNode;
                newNode.prePointer = node;
                break;
            }

            node = node.nextPointer;
        }

    }

    static void delete(int index) {
        Node node = head.nextPointer;

        while (true) {
            if (node == null) {
                System.out.println("Index Error");
                return;
            }

            if (index == 0) {
                node.prePointer.nextPointer = node.nextPointer;
                node.nextPointer.prePointer = node.prePointer;
                return;
            }

            node = node.nextPointer;
            index--;
        }
    }

    static void print_linked_list2() {

        Node node = head.nextPointer;

        while (node != null) {
            if (node.nextPointer != null) {
                System.out.print(node.data + " ->");
            } else {
                System.out.println(node.data);
            }

            node = node.nextPointer;
        }
    }
}

class Node {

    public Node prePointer;
    public Object data;
    public Node nextPointer;


    public Node(Object data) {
        this.prePointer = null;
        this.data = data;
        this.nextPointer = null;
    }
}