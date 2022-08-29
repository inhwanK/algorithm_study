package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 정답 풀이와 동일
// dp 풀이는 테이블을 정의하고,... 하나하나 해보면서 다른 규칙을 찾아야 함.
// 합분해 - https://www.acmicpc.net/problem/2225
public class BOJ2225 {
    static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] arr = new int[201][201];

        for (int i = 1; i <= 200; i++) {
            arr[1][i] = i;
        }

        for (int i = 2; i <= 200; i++) {
            arr[i][1] = 1;
            for (int j = 1; j <= 200; j++) {
                arr[i][j] = (int) ((arr[i][j - 1] + arr[i - 1][j]) % MOD);
            }
        }

        System.out.println(arr[n][k]);
    }
}