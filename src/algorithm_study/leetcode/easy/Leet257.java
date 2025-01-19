package algorithm_study.leetcode.easy;

import java.util.*;

// 257. Binary Tree Paths - https://leetcode.com/problems/binary-tree-paths/description/
public class Leet257 {
    public ArrayList<String> answer = new ArrayList();

    public List<String> binaryTreePaths(TreeNode root) {

        recursive(root, "");
        return answer;
    }

    public void recursive(TreeNode now, String result) {
        result += now.val;
        if (now.left != null) {
            recursive(now.left, result + "->");
        }
        if (now.right != null) {
            recursive(now.right, result + "->");
        }
        if (now.left == null && now.right == null) {
            answer.add(result);
            return;
        }
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