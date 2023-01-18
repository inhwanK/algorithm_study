package algorithm_study.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 회의실 배정 - https://www.acmicpc.net/problem/1931
public class BOJ1931 {
    /*
    11
    1 4
    3 5
    0 6
    5 7
    3 8
    5 9
    6 10
    8 11
    8 12
    2 13
    12 14
    */

    public static void main(String[] args) throws IOException {
        // N개의 회의에 대해
        // 각 회의 I의 시작시간과 종료시간 주어짐
        // 각 회의가 겹치지 않게 회의실을 사용할 수 있는 최대 갯수 구하기
        // 회의 중간에 중단 안됨, 끝남과 동시에 바로 다음회의 가능

        // 이거 정렬하면 될 것 같던데..

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int index = 0;
        int fin = 0;
        int answer = 0;
        while (index < n) {

            if (fin <= arr[index][0]) {
                fin = arr[index][1];
                answer++;
            }

            index++;
        }
        System.out.println(answer);
    }
}