package algorithm_study.programers.level1;

import java.util.*;
// 대충 만든 자판 - https://school.programmers.co.kr/learn/courses/30/lessons/160586
public class Pro160586 {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> pressCountMap = new HashMap();

        // keymap 모두 돌면, 100 * 100;
        // 문자별 최소 누르는 횟수
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                int c = j + 1;
                if (pressCountMap.containsKey(keymap[i].charAt(j))) {
                    int count = pressCountMap.get(keymap[i].charAt(j));
                    c = count >= c ? c : count;
                }
                pressCountMap.put(keymap[i].charAt(j), c);
            }
        }

        int[] answer = new int[targets.length];

        // 100 * 100
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                if (!pressCountMap.containsKey(targets[i].charAt(j))) {
                    answer[i] = -1;
                    break;
                }

                int count = pressCountMap.get(targets[i].charAt(j));
                answer[i] += count;
            }
        }

        return answer;
    }
}
