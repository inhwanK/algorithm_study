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

    /*
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb, List<String> ans) {
        int prev = sb.length();
        if (prev > 0) sb.append("->");
        sb.append(node.val);

        if (node.left == null && node.right == null) {
            ans.add(sb.toString());
        } else {
            if (node.left != null)  dfs(node.left,  sb, ans);
            if (node.right != null) dfs(node.right, sb, ans);
        }
        sb.setLength(prev); // 백트래킹
    }*/
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