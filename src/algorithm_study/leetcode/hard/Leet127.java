package algorithm_study.leetcode.hard;

import java.util.*;

// Word Ladder - https://leetcode.com/problems/word-ladder/description/
public class Leet127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // wordList에 endword 없으면 0 반환
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 맵<리스트> 만들기
        Map<String, List<String>> wordMap = new HashMap<>();
        // 한 글자만 차이나는 단어들끼리 맵<리스트> 넣기
        wordMap.put(beginWord, new ArrayList<>());
        setList(wordList, wordMap, beginWord);

        for (int i = 0; i < wordList.size(); i++) {
            String now = wordList.get(i);
            wordMap.put(now, new ArrayList());
            setList(wordList, wordMap, now);
        }


        // beginword를 시작으로 bfs?
        int result = 0;
        Queue<Word> que = new LinkedList();
        HashSet<String> visitedSet = new HashSet();

        que.add(new Word(1, beginWord));
        visitedSet.add(beginWord);

        while (!que.isEmpty()) {
            Word now = que.poll();
            if (now.word.equals(endWord)) {
                return now.index;
            }
            List<String> list = wordMap.get(now.word);

            for (int i = 0; i < list.size(); i++) {
                if (!visitedSet.contains(list.get(i))) {
                    que.add(new Word(now.index + 1, list.get(i)));
                    visitedSet.add(list.get(i));
                }
            }
        }
        return result;
    }

    private void setList(List<String> wordList, Map<String, List<String>> wordMap, String now) {
        for (int j = 0; j < wordList.size(); j++) {
            if (checkSpell(now, wordList.get(j))) {
                wordMap.get(now).add(wordList.get(j));
            }
        }
    }

    // 한글자 차이 판별 메서드
    private boolean checkSpell(String now, String target) {
        int count = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}

class Word {
    int index;
    String word;

    public Word(int index, String word) {
        this.index = index;
        this.word = word;
    }
}
