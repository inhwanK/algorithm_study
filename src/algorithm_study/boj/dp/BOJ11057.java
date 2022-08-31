package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 상위 정답이랑 동일한 풀이
// 오르막 수 - https://www.acmicpc.net/problem/11057
public class BOJ11057 {
    static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][10];
        Arrays.fill(arr[1], 1);

        for (int i = 2; i <= n; i++) {
            arr[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % MOD;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result += arr[n][i];
        }
        System.out.println(result % MOD);
    }
}