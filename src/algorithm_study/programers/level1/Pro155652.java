package algorithm_study.programers.level1;

import java.util.*;

// 둘만의 암호 - https://school.programmers.co.kr/learn/courses/30/lessons/155652
public class Pro155652 {
    public String solution(String s, String skip, int index) {
        String answer = "";

        String target = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < skip.length(); i++) {
            target = target.replace(String.valueOf(skip.charAt(i)), "");
        }

        int size = target.length();
        HashMap<Character, Integer> map = new HashMap();

        for (int i = 0; i < size; i++) {
            map.put(target.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) + index >= size) {
                answer += target.charAt((map.get(s.charAt(i)) + index) % size);
                continue;
            }

            answer += target.charAt(map.get(s.charAt(i)) + index);
        }
        return answer;
    }

    public String solution_answer1(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            char temp = letter;
            int idx = 0;
            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);
                if (!skip.contains(String.valueOf(temp))) {
                    idx += 1;
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }
}
