package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이친수 - https://www.acmicpc.net/problem/2193
public class BOJ2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[91][2];
        arr[1][1] = 1;
        arr[2][0] = arr[1][1] + arr[1][0];
        arr[2][1] = arr[1][0];

        for (int i = 3; i < 91; i++) {
            arr[i][0] = arr[i - 1][1] + arr[i - 1][0];
            arr[i][1] = arr[i - 1][0];
        }

        System.out.println(arr[n][0] + arr[n][1]);
    }
}


// 피보나치 수열과 비슷한 점화식이 나오는 듯
class BOJ2193Answer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] d = new long[n + 1];

        d[0] = 0;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }
}
