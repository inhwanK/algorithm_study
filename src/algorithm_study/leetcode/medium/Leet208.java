package algorithm_study.leetcode.medium;

import java.util.*;

// Implement Trie (Prefix Tree) - https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class Leet208 {

}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfCharacter;

    public TrieNode() {
        this.children = new HashMap<>();
        this.endOfCharacter = false;
    }
}

class Trie2 {
    TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            char now = w[i];
            if (!node.children.containsKey(now)) {
                node.children.put(now, new TrieNode());
                node = node.children.get(now);
                continue;
            }
            node = node.children.get(now);
        }
        node.endOfCharacter = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            char now = w[i];
            if (node.children == null || !node.children.containsKey(now)) {
                return false;
            }
            node = node.children.get(now);
        }

        return node.endOfCharacter;
    }

    // 1. startsWith 로직 먼저 고민하기
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] w = prefix.toCharArray();
        for (int i = 0; i < w.length; i++) {
            char now = w[i];
            if (node.children == null || !node.children.containsKey(now)) {
                return false;
            }
            node = node.children.get(now);
        }
        return true;
    }
}


// answer 1
class Trie1 {
    private Map<String, List<String>> dataMap;

    public Trie1() {
        // Map<String, List<String>> 타입 선언
        dataMap = new HashMap<>();
    }

    public void insert(String word) {
        // O(n * m)
        // key는 word, List<String> 요소는 word의 부분 문자열
        // key - ArrayList 생성
        dataMap.put(word, dataMap.getOrDefault(word, new ArrayList()));
        String pre = "";

        List<String> list = dataMap.get(word);
        // 문자열에서 문자 하나씩 더해가면서 List에 add
        for (int i = 0; i < word.length(); i++) {
            pre += word.charAt(i);
            list.add(pre);
        }
    }

    public boolean search(String word) {
        return dataMap.containsKey(word);
    }

    // 1. startsWith 로직 먼저 고민하기
    public boolean startsWith(String prefix) {
        // O(n * m)

        // search 되면 true
        if (search(prefix)) {
            return true;
        }

        Set<String> keys = dataMap.keySet();
        // 모든 맵 순회
        for (String key : keys) {
            // 키에 해당하는 리스트가 prefix를 contains하는지 확인
            if (dataMap.get(key).contains(prefix)) {
                return true;
            }
        }

        return false;
    }
}