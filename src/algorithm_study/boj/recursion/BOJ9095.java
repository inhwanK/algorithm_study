package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 상위 정답과 큰 차이 없음
// 1, 2, 3 더하기 - https://www.acmicpc.net/problem/9095
public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[11];
        arr[0] = arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 0; i < 11; i++) {
            if(arr[i] == 0) {
                arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
            }
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append('\n');
        }
        System.out.println(sb);
    }
}