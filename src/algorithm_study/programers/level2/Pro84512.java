package algorithm_study.programers.level2;

import java.util.*;

// 모음사전 - https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class Pro84512 {
    public int solution(String word) {
        int answer = word.length();
        char[] dict = {'A', 'E', 'I', 'O', 'U'};
        int[] dp = new int[5];
        dp[0] = 1;
        for (int i = 1; i < 5; i++) {
            dp[i] = dp[i - 1] * 5 + 1;
        }

        for (int i = 0; i < word.length(); i++) {
            int index = indexOf(word.charAt(i), dict);
            answer += dp[5 - 1 - i] * index;
        }
        return answer;
    }

    public int indexOf(char c, char[] dict) {
        for (int i = 0; i < 5; i++) {
            if (dict[i] == c) {
                return i;
            }
        }
        return 0;
    }
}

class Pro84512Answer_1 {
    List<String> list = new ArrayList<>();

    void dfs(String str, int len) {
        if (len > 5) return;
        list.add(str);
        for (int i = 0; i < 5; i++) {
            dfs(str + "AEIOU".charAt(i), len + 1);
        }
    }

    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}

class Pro84512Answer_2 {
    public int solution(String word) {
        String str = "AEIOU";
        int[] x = {781, 156, 31, 6, 1};
        int index, result = word.length();
        for (int i = 0; i < word.length(); i++) {
            index = str.indexOf(word.charAt(i));
            result += x[i] * index;
        }
        return result;
    }
}