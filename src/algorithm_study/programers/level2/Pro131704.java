package algorithm_study.programers.level2;

import java.util.*;

// 택배상자 - https://school.programmers.co.kr/learn/courses/30/lessons/131704
public class Pro131704 {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        int index = 1;
        for (int i = 0; i < order.length; i++) {
            while (index <= order[i]) {
                stack.push(index);
                index++;
            }

            if (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                answer++;
                continue;
            }

            if (index > order[i]) {
                break;
            }
        }

        return answer;
    }

    public static int solutionAnswer(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();

        int idx = 0;

        for (int i = 1; i <= order.length; i++) {
            boolean flag = false;
            //1. 꺼낸 택배상자가 순서에 맞을때
            if (i == order[idx]) {
                idx++;
                answer++;
                flag = true;
            }
            //2. 꺼낸 택배상자가 순서에 맞지 않지만, 보조 컨테이너에서 꺼낸 택배가 순서에 맞을 때 (맞으면 계속 꺼내준다)
            while (!s.isEmpty() && s.peek() == order[idx]) {
                s.pop();
                idx++;
                answer++;
                flag = true;
            }
            //3. 둘다 아닐 때는 보조 컨테이너에 넣는다
            if (!flag) {
                s.add(i);
            }
        }

        //4. 남은 상자들을 보조 컨테이너에서 빼준다
        while (!s.isEmpty() && s.peek() == order[idx]) {
            s.pop();
            idx++;
            answer++;
        }

        return answer;
    }
}
