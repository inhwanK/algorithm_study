package algorithm_study.mogakco.tree;

import java.util.Stack;

public class TreeSearch {

    public static void main(String[] args) {
        Node root = initTree();
        preOrderSearch(root);
        System.out.println();
        inOrderSearch(root);
        System.out.println();
        postOrderSearch(root);
    }

    public static Node initTree() {
        Node root = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);

        root.left = node2;
        root.right = node3;

        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node2.left = node4;
        node2.right = node5;

        return root;
    }

    static void preOrderSearch(Node node) {

        if (node == null) {
            return;
        }
//        nodeStack.push(node);
        System.out.print("노드 : " + node.data + " -> ");
        preOrderSearch(node.left);
        preOrderSearch(node.right);

    }

    static void inOrderSearch(Node node){
        if (node == null) {
            return;
        }
//        nodeStack.push(node);

        inOrderSearch(node.left);
        System.out.print("노드 : " + node.data + " -> ");
        inOrderSearch(node.right);
    }

    static void postOrderSearch(Node node){
        if (node == null) {
            return;
        }
//        nodeStack.push(node);

        postOrderSearch(node.left);
        postOrderSearch(node.right);
        System.out.print("노드 : " + node.data + " -> ");
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