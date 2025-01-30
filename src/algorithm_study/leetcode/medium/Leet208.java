package algorithm_study.leetcode.medium;

import java.util.*;

// Implement Trie (Prefix Tree) - https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class Leet208 {

}

class Trie {
    private Map<String, List<String>> dataMap;

    public Trie() {
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