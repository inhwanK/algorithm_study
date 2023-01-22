package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연속합 2 - https://www.acmicpc.net/problem/13398
public class BOJ13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        String[] input = br.readLine().split(" ");

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        dpLeft[0] = max = arr[0];
        dpRight[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            dpLeft[i] = Math.max(dpLeft[i - 1] + arr[i], arr[i]);
            max = Math.max(dpLeft[i], max);
        }

        for (int i = n - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i + 1] + arr[i], arr[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            max = Math.max(dpLeft[i - 1] + dpRight[i + 1], max);
        }
        System.out.println(max);
    }
}