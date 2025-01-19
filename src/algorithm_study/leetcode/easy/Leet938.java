package algorithm_study.leetcode.easy;

// Range Sum of BST - https://leetcode.com/problems/range-sum-of-bst/description/
public class Leet938 {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        recursive(root, low, high);
        return sum;
    }

    // 다른 유저 solution
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) return 0; // base case.
        if (root.val < L) return rangeSumBST2(root.right, L, R); // left branch excluded.
        if (root.val > R) return rangeSumBST2(root.left, L, R); // right branch excluded.
        return root.val + rangeSumBST2(root.right, L, R) + rangeSumBST2(root.left, L, R); // count in both children.
    }

    void recursive(TreeNode target, int low, int high) {
        if (target.val >= low && target.val <= high) {
            sum += target.val;
            if (target.left != null) {
                recursive(target.left, low, high);
            }
            if (target.right != null) {
                recursive(target.right, low, high);
            }
            return;
        }

        if (target.val < low) {
            if (target.right != null) {
                recursive(target.right, low, high);
            }
        }

        if (target.val > high) {
            if (target.left != null) {
                recursive(target.left, low, high);
            }
        }
        return;
    }


    public class TreeNode {
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

}
