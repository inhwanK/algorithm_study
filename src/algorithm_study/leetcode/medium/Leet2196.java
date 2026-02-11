package algorithm_study.leetcode.medium;

import java.util.*;

// 2196. Create Binary Tree From Descriptions - https://leetcode.com/problems/create-binary-tree-from-descriptions/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap();
        Set<Integer> set = new HashSet();
        for (int i = 0; i < descriptions.length; i++) {
            if (!map.containsKey(descriptions[i][0])) {
                map.put(descriptions[i][0], new TreeNode(descriptions[i][0]));
            }
            TreeNode now = map.get(descriptions[i][0]);

            if (!map.containsKey(descriptions[i][1])) {
                map.put(descriptions[i][1], new TreeNode(descriptions[i][1]));
            }

            TreeNode target = map.get(descriptions[i][1]);
            set.add(descriptions[i][1]);
            if (descriptions[i][2] == 1) {
                now.left = target;
            } else {
                now.right = target;
            }
        }

        int resultKey = 0;
        for (int key : map.keySet()) {
            if (!set.contains(key)) {
                resultKey = key;
                break;
            }
        }

        return map.get(resultKey);
    }

    public TreeNode createBinaryTree2(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> parents = new HashSet<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int p = d[0], c = d[1], isLeft = d[2];

            TreeNode parent = nodes.computeIfAbsent(p, TreeNode::new);
            TreeNode child  = nodes.computeIfAbsent(c, TreeNode::new);

            if (isLeft == 1) parent.left = child;
            else parent.right = child;

            parents.add(p);
            children.add(c);
        }

        // root = parent에만 있고 child에는 없는 값
        parents.removeAll(children);
        int rootVal = parents.iterator().next();
        return nodes.get(rootVal);
    }
}
