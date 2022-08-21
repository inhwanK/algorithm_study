package algorithm_study.programers;

import java.util.ArrayList;

// 같은 숫자는 싫어 - https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class Pro12906 {
    public int[] solution(int[] arr) {
        int[] answer;

        ArrayList<Integer> list = new ArrayList<>();
        int pre = 10;
        for (int i = 0; i < arr.length; i++) {
            if (pre != arr[i]) {
                list.add(arr[i]);
                pre = arr[i];
            }
        }

        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
