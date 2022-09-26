package algorithm_study.programers.level1;

import java.util.*;
// 정수 내림차순으로 배치하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12933
public class Pro12933 {
    public long solution(long n) {
        long answer = 0;

        String input = n + "";
        int[] arr = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i) - '0';
        }

        Arrays.sort(arr);
        String output = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            output += arr[i];
        }
        answer = Long.parseLong(output);
        return answer;
    }

    public long solution_1(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
    }
}
