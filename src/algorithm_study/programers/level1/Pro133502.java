package algorithm_study.programers.level1;

import java.util.*;

// 햄버거 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/133502
public class Pro133502 {
    public int solution(int[] ingredient) {
        int answer = 0;
        // 1 2 3 1
        String target = "";
        for (int i = 0; i < ingredient.length; i++) {
            target += ingredient[i];
        }
        // ----------------

        int pre = target.length();
        int now = pre;
        do {
            pre = now;
            target = target.replace("1231", "");
            now = target.length();
        } while (now < pre);

        return (ingredient.length - now) / 4;
    }

    public int solution2(int[] ingredient) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int in : ingredient) {
            stack.push(in);
            if (stack.size() >= 4) {
                int size = stack.size();
                if(stack.get(size - 1) == 1
                        && stack.get(size - 2) == 3
                        && stack.get(size - 3) == 2
                        && stack.get(size - 4) == 1) {
                    result++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return result;
    }
}
