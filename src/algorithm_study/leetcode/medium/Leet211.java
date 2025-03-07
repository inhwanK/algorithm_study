package algorithm_study.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// Design Add And Search Words Data Structure - https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
public class Leet211 {
    Node1 root;

    public Leet211() {
        root = new Node1();
    }

    public void addWord(String word) {
        char[] wordArr = word.toCharArray();
        Node1 node1 = root;
        for(char c : wordArr) {
            node1.children.putIfAbsent(c, new Node1());
            node1 = node1.children.get(c);
        }
        node1.endOfWord = true;
    }

    public boolean search(String word) {
        char[] wordArr = word.toCharArray();
        return dfs(root, wordArr, 0);
    }


    private boolean dfs(Node1 node1, char[] wordArr, int index) {
        if(wordArr.length <= index) {
            return node1.endOfWord;
        }

        if(wordArr[index] == '.') {
            for(Node1 now : node1.children.values()) {
                if(dfs(now, wordArr, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if(!node1.children.containsKey(wordArr[index])) {
                return false;
            }
            return dfs(node1.children.get(wordArr[index]), wordArr, index + 1);
        }
    }
}

class Node1 {
    Map<Character, Node1> children = new HashMap<>();
    boolean endOfWord = false;
}
