package algorithm_study.programers.level2;

import java.util.Stack;

// 주식가격 - https://school.programmers.co.kr/learn/courses/30/lessons/42584
public class Pro42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}

class Pro42584Answer {
    public int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i = 0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i = 1; i < prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
}
