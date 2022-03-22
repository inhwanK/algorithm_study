package algorithm_study.mogakco.tree;

public class Quiz11_3 {

    public static void main(String[] args) {
        Node root = initTree();

//      전위 순회
        preOrderSearch(root, 0);
        System.out.println();
        System.out.println("가장 깊은 레벨에 존재하는 노드 : " + deepData);
        System.out.println("트리의 높이 : " + depth);

        // 중위 순회
        depth = 0;
        deepData = null;

        inOrderSearch(root, 0);
        System.out.println();
        System.out.println("가장 깊은 레벨에 존재하는 노드 : " + deepData);
        System.out.println("트리의 높이 : " + depth);

        // 후위 순회
        depth = 0;
        deepData = null;

        postOrderSearch(root, 0);
        System.out.println();
        System.out.println("가장 깊은 레벨에 존재하는 노드 : " + deepData);
        System.out.println("트리의 높이 : " + depth);

    }

    static int depth = 0;
    static Object deepData;

    static Node initTree() {
        Node root = new Node(7);

        Node node1 = new Node(3);
        Node node2 = new Node(10);

        root.left = node1;
        root.right = node2;

        Node node3 = new Node(1);
        Node node4 = new Node(5);

        node1.left = node3;
        node1.right = node4;

        Node node5 = new Node(4);

        node4.left = node5;

        Node node6 = new Node(12);

        node5.left = node6;

        Node node7 = new Node(8);

        node2.left = node7;

        return root;
    }

    static void preOrderSearch(Node node, int level) {
        if (node == null) {
            return;
        }

        if (depth < level) {
            depth = level;
            deepData = node.data;
        }

        level++;
        System.out.print(node.data + " ");
        preOrderSearch(node.left, level);
        preOrderSearch(node.right, level);
    }

    static void inOrderSearch(Node node, int level) {
        if (node == null) {
            return;
        }

        if (depth < level) {
            depth = level;
            deepData = node.data;
        }

        level++;
        inOrderSearch(node.left, level);
        System.out.print(node.data + " ");
        inOrderSearch(node.right, level);
    }

    static void postOrderSearch(Node node, int level) {
        if (node == null) {
            return;
        }

        if (depth < level) {
            depth = level;
            deepData = node.data;
        }

        level++;
        postOrderSearch(node.left, level);
        postOrderSearch(node.right, level);
        System.out.print(node.data + " ");
    }
}

class Node {

    Object data;
    Node left;
    Node right;

    public Node(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}