package algorithm_study.programers.level2;

import java.util.*;

// 짝지어 제거하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12973
public class Pro12973 {
    public int solution(String s) {
        int answer = 0;
        Stack<String> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            if (!stack.isEmpty()) {
                if (stack.peek().equals(temp)) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(temp);
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return answer;
    }
}
