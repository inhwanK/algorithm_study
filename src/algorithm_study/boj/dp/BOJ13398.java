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
        String[] input = br.readLine().split(" ");

        int result = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int j = 0; j < n; j++) {
            result += arr[j];
            if (result <= 0) {
                result = 0;
                continue;
            }

            max = Math.max(result, max);
        }
        System.out.println(max);
    }
}
