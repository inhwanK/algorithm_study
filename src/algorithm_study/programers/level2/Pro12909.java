package algorithm_study.programers.level2;

import java.util.Stack;

// 올바른 괄호 - https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Pro12909 {
    boolean solution(String s) {
        char[] input = s.toCharArray();

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < input.length; i++) {
            if (stack.isEmpty() && input[i] == ')') {
                return false;
            }

            if (input[i] == '(') {
                stack.push(1);
            } else {
                stack.pop();
            }

        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    boolean solution_answer(String s) {
        boolean answer = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                break;
            }
        }
        if (count == 0) {
            answer = true;
        }

        return answer;
    }
}
