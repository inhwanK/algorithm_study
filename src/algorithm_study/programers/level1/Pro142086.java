package algorithm_study.programers.level1;

import java.util.*;

// 가장 가까운 같은 글자 https://school.programmers.co.kr/learn/courses/30/lessons/142086?language=java
public class Pro142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        // s가 주어짐 > s의 각 위치마다 자신보다 앞에 나오면서 가장 가까운 곳.
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            int last = map.getOrDefault(now, i);
            if (last == i) {
                answer[i] = -1;
            } else {
                answer[i] = i - last;
            }
            map.put(now, i);
        }

        return answer;
    }
}
