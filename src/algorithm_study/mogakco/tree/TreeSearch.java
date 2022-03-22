package algorithm_study.mogakco.tree;

import java.util.Stack;

public class TreeSearch {

    public static void main(String[] args) {
        NodeEx root = initTree();
        preOrderSearch(root);
        System.out.println();
        inOrderSearch(root);
        System.out.println();
        postOrderSearch(root);
    }

    public static NodeEx initTree() {
        NodeEx root = new NodeEx(1);

        NodeEx node2 = new NodeEx(2);
        NodeEx node3 = new NodeEx(3);

        root.left = node2;
        root.right = node3;

        NodeEx node4 = new NodeEx(4);
        NodeEx node5 = new NodeEx(5);

        node2.left = node4;
        node2.right = node5;

        return root;
    }

    static void preOrderSearch(NodeEx node) {

        if (node == null) {
            return;
        }
//        nodeStack.push(node);
        System.out.print("노드 : " + node.data + " -> ");
        preOrderSearch(node.left);
        preOrderSearch(node.right);

    }

    static void inOrderSearch(NodeEx node){
        if (node == null) {
            return;
        }
//        nodeStack.push(node);

        inOrderSearch(node.left);
        System.out.print("노드 : " + node.data + " -> ");
        inOrderSearch(node.right);
    }

    static void postOrderSearch(NodeEx node){
        if (node == null) {
            return;
        }
//        nodeStack.push(node);

        postOrderSearch(node.left);
        postOrderSearch(node.right);
        System.out.print("노드 : " + node.data + " -> ");
    }
}

class NodeEx {

    Object data;
    NodeEx left;
    NodeEx right;

    public NodeEx(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}