package algorithm_study.programers.level2;

import java.util.*;

// 수식 최대화 - https://school.programmers.co.kr/learn/courses/30/lessons/67257
public class Pro67257 {
    public long solution(String expression) {
        long answer = 0;

        ArrayList<Character> operations = new ArrayList();
        ArrayList<Long> operand = new ArrayList();

        String temp = "";
        for (int i = 0; i < expression.length(); i++) {
            char target = expression.charAt(i);
            if (!Character.isDigit(target)) {
                operations.add(target);
                operand.add(Long.parseLong(temp));
                temp = "";
                continue;
            }

            temp += target;

            if (i == expression.length() - 1) {
                operand.add(Long.parseLong(temp));
            }
        }

        String[] order = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};

        ArrayList<Character> operationsCopy = (ArrayList<Character>) operations.clone();
        ArrayList<Long> operandCopy = (ArrayList<Long>) operand.clone();

        for (int i = 0; i < 6; i++) {
            String o = order[i];
            for (int j = 0; j < 3; j++) {
                char now = o.charAt(j);
                int index = 0;
                while (index < operationsCopy.size()) {
                    if (now == operationsCopy.get(index)) {
                        long result = calc(operandCopy.get(index), operandCopy.get(index + 1), now);
                        operandCopy.set(index, result);
                        operandCopy.remove(index + 1);
                        operationsCopy.remove(index);
                        continue;
                    }
                    index++;
                }
            }
            answer = Math.max(answer, Math.abs(operandCopy.get(0)));

            operationsCopy = (ArrayList<Character>) operations.clone();
            operandCopy = (ArrayList<Long>) operand.clone();
        }

        return answer;
    }

    private long calc(long left, long right, char oper) {
        if (oper == '*') {
            return left * right;
        } else if (oper == '+') {
            return left + right;
        } else {
            return left - right;
        }
    }
}
