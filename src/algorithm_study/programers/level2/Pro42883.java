package algorithm_study.programers.level2;

import java.util.Stack;

// 큰 수 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class Pro42883 {
    public String solution(String number, int k) {
        String answer = "";

        int n = number.length() - k;
        int num = 0;
        int index = 0;

        for (int i = n; i > 0; i--) {
            num = 0;
            for (int j = index; j < number.length() - (i - 1); j++) {
                int now = number.charAt(j) - '0';

                if (now == 9) {
                    num = now;
                    index = j + 1;
                    break;
                }

                if (now > num) {
                    num = now;
                    index = j + 1;
                }
            }
            answer += String.valueOf(num);
        }
        return answer;
    }

    public String answer_1(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

    public String answer_2(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i + 1 < sb.length() && k > 0; i++) {
            if (sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                i = -1;
                k--;
            }
        }
        if (k != 0)
            sb.delete(sb.length() - k, sb.length());
        return sb.toString();
    }
}
