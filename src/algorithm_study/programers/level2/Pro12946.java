package algorithm_study.programers.level2;

import java.util.*;

// 하노이의 탑 - https://school.programmers.co.kr/learn/courses/30/lessons/12946
public class Pro12946 {
    private ArrayList<int[]> list = new ArrayList();

    public int[][] solution(int n) {


        // N개, 출발지 -> 도착지
        // N-1개, 출발지 -> 경유지 + 1개, 출발지 -> 도착지 + N-1개, 경유지 -> 도착지
        // N-2개, 출발지 -> 경유지 .........

        rec(n, 1, 2, 3);
        // int[][] answer = new int[list.size()][2];
        // for(int i = 0; i < list.size(); i++) {
        //     answer[i] = list.get(i);
        // }

        int[][] answer = list.stream()
                .toArray(int[][]::new);

        return answer;
    }

    private void rec(int count, int start, int mid, int end) {
        if (count == 0) {
            return;
        }

        rec(count - 1, start, end, mid);
        list.add(new int[]{start, end});
        rec(count - 1, mid, start, end);
    }
}