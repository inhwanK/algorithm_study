package algorithm_study.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
// word break 2 - https://leetcode.com/problems/word-break-ii/description/
public class Leet140 {
    List<String> resultList = new ArrayList();

    public List<String> wordBreak(String s, List<String> wordDict) {
        // answer 2 - wordDict 기준으로 단어 체크해가면서 띄어쓰기 하기 (복잡도는 더 유리함)
        // 트라이 클래스 추가
        // 트라이 wordDict로 트라이 값 탐색 로직 작성
        TrieNode root = new TrieNode(s, "");
        root.slice(wordDict);

        sliceByDfs(root, wordDict);
        return resultList;
    }

    private void sliceByDfs(TrieNode node, List<String> wordDict) {
        // null 체크?
        String total = node.total;
        if ("".equals(total) || total.length() == 0) {
            resultList.add(node.result.substring(1));
            return;
        }

        List<TrieNode> children = node.children;
        for (int i = 0; i < children.size(); i++) {
            TrieNode child = children.get(i);
            child.slice(wordDict);
            sliceByDfs(child, wordDict);
        }
    }
}

class TrieNode {
    List<TrieNode> children;
    String total;
    String result = "";

    public TrieNode(String total, String result) {
        this.children = new ArrayList();
        this.total = total;
        this.result = result;
    }

    public void slice(List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (total.startsWith(word)) {
                String childTotal = total.substring(word.length());
                children.add(new TrieNode(childTotal, result + " " + word));
            }
        }
    }
}
