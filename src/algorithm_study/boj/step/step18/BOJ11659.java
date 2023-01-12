package algorithm_study.boj.step.step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 구간 합 구하기 4 - https://www.acmicpc.net/problem/11659
public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] dp = new int[n + 1];

        String[] arrInput = br.readLine().split(" ");


        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(arrInput[i - 1]);
        }

        for (int i = 0; i < m; i++) {
            String[] range = br.readLine().split(" ");
            int left = Integer.parseInt(range[0]);
            int right = Integer.parseInt(range[1]);
            System.out.println(dp[right] - dp[left - 1]);
        }
    }
}