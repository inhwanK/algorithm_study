package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1로 만들기 - https://www.acmicpc.net/problem/1463
public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[1000001];
        arr[0] = 0;
        arr[1] = arr[2] = arr[3] = 1;

        int min = 1000001;
        for (int i = 4; i < x; i++) {
            if (i % 3 == 0) {
                min = Math.min(arr[i - 1] + 1, arr[i / 3] + 1);
            }
            if (i % 2 == 0) {
                arr[i] = Math.min(min, arr[i / 2] + 1);
            }
            System.out.println(i + " > " + arr[i]);
        }
        System.out.println(arr[x]);
    }
}
