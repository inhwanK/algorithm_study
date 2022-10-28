package algorithm_study.programers.level2;

import java.util.*;

// 괄호 회전하기 - https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Pro76502 {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, s.length()) + s.substring(0, i);
            char first = temp.charAt(0);
            char last = temp.charAt(temp.length() - 1);

            if (first == ')' || first == ']' || first == '}' || last == '(' || last == '[' || last == '{') {
                continue;
            }

            for (int j = 0; j < s.length(); j++) {
                char target = temp.charAt(j);

                if (target == '(' || target == '[' || target == '{') {
                    stack.push(temp.charAt(j));
                } else {
                    if (stack.isEmpty()) {
                        answer--;
                        break;
                    }

                    if (stack.peek() == '(' && target == ')') {
                        stack.pop();
                        continue;
                    }
                    if (stack.peek() == '[' && target == ']') {
                        stack.pop();
                        continue;
                    }
                    if (stack.peek() == '{' && target == '}') {
                        stack.pop();
                        continue;
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
            stack.clear();
        }
        return answer;
    }
}

class Pro76502Answer {
    private final Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        int answer = 0;
        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(stringBuilder.charAt(0));
            stringBuilder.deleteCharAt(0);
            if (correctParenthesis(stringBuilder.toString().toCharArray()))
                answer++;
        }
        return answer;
    }

    private boolean correctParenthesis(char[] s) {
        for (char c : s) {
            if (!(check(c, '(', ')') && check(c, '[', ']') && check(c, '{', '}')))
                return false;
        }
        return stack.isEmpty();
    }

    private boolean check(char c, char a, char b) {
        if (c == a)
            stack.push(a);
        else if (c == b)
            if (!stack.isEmpty() && stack.peek() == a) stack.pop();
            else return false;
        return true;
    }
}

