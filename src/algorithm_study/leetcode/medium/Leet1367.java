package algorithm_study.leetcode.medium;

// 1367. Linked List in Binary Tree - https://leetcode.com/problems/linked-list-in-binary-tree/
public class Leet1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(TreeNode root, ListNode head) {
        if (head == null) return true;
        if (root == null) return false;
        if (root.val != head.val) {
            return false;
        }

        return dfs(root.left, head.next) || dfs(root.right, head.next);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}