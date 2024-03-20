package algorithm_study.programers.level3;

import java.util.*;

public class Pro42892 {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        ArrayList<Node> list = new ArrayList();
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            list.add(new Node(x, y, i + 1));
        }

        Collections.sort(list, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                if (o2.y == o1.y) {
                    return o1.x - o2.x;
                }
                return o2.y - o1.y;
            }
        });

        Queue<Node> que = new LinkedList();
        Node root = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Node now = list.get(i);
            root.add(now);
        }

        ArrayList<Integer> leftList = new ArrayList();
        ArrayList<Integer> rightList = new ArrayList();

        root.preOrderSearch(leftList);
        root.postOrderSearch(rightList);

        answer = new int[2][nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = leftList.get(i);
            answer[1][i] = rightList.get(i);
        }

        return answer;
    }

    class Node {
        int x;
        int y;
        int index;
        Node left;
        Node right;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public void add(Node node) {
            if (leftCheck(node)) {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            }
        }

        private boolean leftCheck(Node node) {
            if (this.x > node.x) {
                return true;
            }
            return false;
        }

        public ArrayList preOrderSearch(ArrayList<Integer> pre) {
            pre.add(index);
            if (left != null) left.preOrderSearch(pre);
            if (right != null) right.preOrderSearch(pre);
            return pre;
        }

        public ArrayList postOrderSearch(ArrayList<Integer> post) {
            if (left != null) left.postOrderSearch(post);
            if (right != null) right.postOrderSearch(post);
            post.add(index);
            return post;
        }
    }
}
