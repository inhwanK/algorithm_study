package algorithm_study.mogakco.linkedlist;

public class LinkedListEx {

    private NodeEx head = new NodeEx(null);

    public NodeEx get(int index) {
        NodeEx node = this.head.pointer;

        while (true) {
            if (index == 0) {
                return node;
            }

            if (node == null) {
                System.out.println("Index Error");
                return null;
            }

            node = node.pointer;
            index--;
        }
    }

    public void append(int data) {
        NodeEx node = head;
        NodeEx newNode = new NodeEx(data);

        while (true) {
            if (node.pointer == null) {
                break;
            }
            node = node.pointer;
        }

        node.pointer = newNode;
    }

    public void insert(int data, int index) {
        NodeEx node = head;
        NodeEx newNode = new NodeEx(data);

        while (true) {
            if (node == null) {
                System.out.println("Index error");
                return;
            }

            if (index == 0) {
                NodeEx nextNode = node.pointer;
                node.pointer = newNode;
                newNode.pointer = nextNode;
                break;
            }

            node = node.pointer;
            index--;
        }
    }

    void delete(int index) {
        if (index == 0) {
            head.pointer = head.pointer.pointer;
        } else {
            NodeEx node = get(index - 1);
            node.pointer = node.pointer.pointer;
        }
    }

    void print_linked_list() {
        NodeEx node = head.pointer;
        while (node != null) {
            if (node.pointer != null) {
                System.out.print(node.data + " ->");
            } else {
                System.out.println(node.data);
            }

            node = node.pointer;
        }
    }
}

class NodeEx {
    public Object data;
    public NodeEx pointer;

    public NodeEx(Object data) {
        this.data = data;
        this.pointer = null;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedListEx LL = new LinkedListEx();

        LL.append(1);
        LL.append(2);
        LL.append(3);
        LL.print_linked_list();

        LL.insert(10, 0);
        LL.print_linked_list();

        LL.insert(20, 3);
        LL.print_linked_list();

        LL.delete(1);
        LL.print_linked_list();

        LL.delete(0);
        LL.print_linked_list();
    }
}