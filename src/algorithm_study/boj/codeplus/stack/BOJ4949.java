package algorithm_study.boj.codeplus.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 풀이 코드 - https://st-lab.tistory.com/180
// 균형잡힌 세상 - https://www.acmicpc.net/problem/4949
public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while (true) {
            s = br.readLine();
            if (s.equals(".")) {    // 종료 조건문
                break;
            }
            System.out.println(solve(s));
        }

    }

    public static String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);    // i 번째 문자
            // 여는 괄호일 경우 스택에 push
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.empty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}