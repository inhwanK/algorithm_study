package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 포도주 시식 - https://www.acmicpc.net/problem/2156
public class BOJ2156 {
    public static int n, dp[], arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = arr[1];
        if (n > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(recursion(n));
    }

    public static int recursion(int t) {

        if (dp[t] == -1) {
            int temp = Math.max(recursion(t - 2), recursion(t - 3) + arr[t - 1]) + arr[t];
            dp[t] = Math.max(temp, recursion(t - 1));
        }

        return dp[t];
    }
}

class BOJ2156Answer_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        int[] dp = new int[10001];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1];
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i]);
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i]);
        }
        System.out.println(dp[n]);
    }
}

class BOJ2156Answer_2 {

    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = arr[1];

        if (N > 1) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(recur(N));
    }

    static int recur(int N) {

        if (dp[N] == null) {
            dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + arr[N - 1]) + arr[N], recur(N - 1));
        }

        return dp[N];
    }
}
