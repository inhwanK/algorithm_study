package algorithm_study.programers.level2;

import java.util.*;

// 뒤에 있는 큰 수 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/154539
public class Pro154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        answer[numbers.length - 1] = -1;

        Stack<Integer> stack = new Stack();
        stack.push(numbers[numbers.length - 1]);

        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] < numbers[i + 1]) {
                stack.push(numbers[i + 1]);
            } else {
                while (!stack.isEmpty()) {
                    if (numbers[i] < stack.peek()) {
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }
        }
        return answer;
    }



    public int[] solutionAnswer(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i < numbers.length; i++){
            while(!s.isEmpty()){
                int idx = s.pop();
                if(numbers[i] > numbers[idx]){ // 뒤가 더 클때
                    answer[idx] = numbers[i];
                } else { // 앞이 더 크거나 같을 때
                    s.push(idx);
                    break;
                }
            }
            s.push(i);
        }

        return answer;
    }
}
