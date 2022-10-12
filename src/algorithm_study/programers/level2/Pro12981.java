package algorithm_study.programers.level2;

import java.util.HashSet;
import java.util.Set;

// 영어 끝말잇기 - https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class Pro12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }

        int person = 0;
        String pre = words[0].charAt(0) + "";
        for (int i = 0; i < words.length; i++) {
            if (!set.contains(words[i]) || !words[i].startsWith(pre)) {
                answer[0] = person + 1;
                answer[1] = i / n + 1;
                break;
            }

            set.remove(words[i]);
            pre = words[i].charAt(words[i].length() - 1) + "";
            person = ++person % n;
        }

        return answer;
    }
}
