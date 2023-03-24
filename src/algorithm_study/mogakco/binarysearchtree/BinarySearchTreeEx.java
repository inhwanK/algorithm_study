package algorithm_study.mogakco.binarysearchtree;

public class BinarySearchTreeEx {

    NodeEx root;
    int level = 0;

    public void setRoot(int data) {
        this.root = new NodeEx(data);
    }

    public void search(NodeEx node, int data) {
        if (node == null) {
            System.out.println("없는 데이터 입니다.");
            level = 0;
            return;
        }

        if (node.data == data) {
            System.out.println(level + " 에서 " + data + " 탐색");
            level = 0;
            return;
        } else if (node.data > data) {
            level++;
            search(node.left, data);
        } else if (node.data < data) {
            level++;
            search(node.right, data);
        }
    }

    public void insert(int data) {

        if (root == null) {
            root.data = data;
        } else {
            insertNode(root, data);
        }

    }

    public void insertNode(NodeEx currentNode, int data) {

        if (currentNode.data == data) {
            System.out.println("중복된 값이 존재합니다.");
            return;
        }

        if (currentNode.data > data) {
            if (currentNode.left == null) {
                currentNode.left = new NodeEx(data);
                System.out.println("삽입된 데이터 : " + data);
            } else {
                insertNode(currentNode.left, data);
            }
        } else if (currentNode.data < data) {
            if (currentNode.right == null) {
                currentNode.right = new NodeEx(data);
                System.out.println("삽입된 데이터 : " + data);
            } else {
                insertNode(currentNode.right, data);
            }
        }
    }

    public NodeEx getNextNode(NodeEx node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    public void delete(int data) {

        if (root == null) {
            System.out.println("노드가 존재하지 않습니다.");
        } else {
            deleteNode(null, root, data);
        }
    }

    private void deleteNode(NodeEx parentNode, NodeEx currentNode, int data) {

        if (currentNode == null) {
            System.out.printf("트리에 %d가 존재하지 않습니다. \n", data);
            return;
        }

        if (data < currentNode.data) {
            deleteNode(currentNode, currentNode.left, data);
        } else if (data > currentNode.data) {
            deleteNode(currentNode, currentNode.right, data);
        } else {
            if (currentNode.left == null && currentNode.right == null) {

                if (data < parentNode.data) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }

            } else if (currentNode.left == null && currentNode.right != null) {
                if (data < parentNode.data) {
                    parentNode.left = currentNode.right;
                } else {
                    parentNode.right = currentNode.right;
                }

            } else if (currentNode.left != null && currentNode.right == null) {
                if (data < parentNode.data) {
                    parentNode.left = currentNode.left;
                } else {
                    parentNode.right = currentNode.left;
                }
            } else if (currentNode.left != null && currentNode.right != null) {
                NodeEx nextNode = getNextNode(currentNode.right);
                currentNode.data = nextNode.data;
                deleteNode(currentNode, currentNode.right, nextNode.data);
            }

        }
    }
}

class NodeEx {

    int data;
    NodeEx left;
    NodeEx right;

    public NodeEx(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Main {

    static void inOrder(NodeEx node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.printf("%d ", node.data);
        inOrder(node.right);
        return;
    }

    public static void main(String[] args) {

        BinarySearchTreeEx bst = new BinarySearchTreeEx();
        bst.setRoot(7);

//        bst.root.left = new NodeEx(3);
//        bst.root.right = new NodeEx(10);
//
//        NodeEx node1 = new NodeEx(3);
//        NodeEx node2 = new NodeEx(10);
//
//        bst.root.left = node1;
//        bst.root.right = node2;
//
//        NodeEx node3 = new NodeEx(1);
//        NodeEx node4 = new NodeEx(5);
//
//        node1.left = node3;
//        node1.right = node4;
//
//        NodeEx node5 = new NodeEx(8);
//
//        node2.left = node5;

        bst.insert(3);
        bst.insert(1);
        bst.insert(5);
        bst.insert(10);
        bst.insert(8);

        System.out.println(bst.root.left.left.data);
        System.out.println(bst.root.left.right.data);
        System.out.println(bst.root.right.left.data);


        bst.insert(4);
        bst.insert(12);
        bst.insert(15);

        System.out.println(bst.root.right.right.data);
        System.out.println(bst.root.right.right.right.data);

        bst.delete(7);
        inOrder(bst.root);
//        bst.search(bst.root, 11);
    }
}