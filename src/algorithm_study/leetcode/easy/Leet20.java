package algorithm_study.leetcode.easy;

import java.util.Stack;

// 20. Valid Parentheses - https://leetcode.com/problems/valid-parentheses/submissions/1841776423/
public class Leet20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
