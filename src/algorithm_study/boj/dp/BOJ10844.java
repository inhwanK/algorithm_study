package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 정답 풀이와 동일
// 쉬운 계단 수 - https://www.acmicpc.net/problem/10844
public class BOJ10844 {
    static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[101][10];

        for (int i = 1; i < 10; i++) {
            arr[1][i] = 1;
        }

        for (int i = 2; i < arr.length; i++) {
            arr[i][0] = arr[i - 1][1] % mod;
            arr[i][9] = arr[i - 1][8] % mod;
            for (int j = 1; j < 9; j++) {
                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % mod;
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += arr[n][i];
        }

        System.out.println(result % mod);
    }
}