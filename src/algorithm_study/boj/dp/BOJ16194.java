package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 정답이랑 거의 동일한 코드
// 카드 구매하기 2 - https://www.acmicpc.net/problem/16194
public class BOJ16194 {
    public static int n, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(input[i]);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                arr[i] = Math.min(arr[i], arr[j] + arr[i - j]);
            }
        }

        System.out.println(arr[n]);
    }
}