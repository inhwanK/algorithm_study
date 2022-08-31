package algorithm_study.boj.dp;

import java.io.*;

// 1, 2, 3 더하기 3 - https://www.acmicpc.net/problem/15988
public class BOJ15988 {
    static int t, n;
    static long MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for (int i = 4; i < 1000001; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % MOD;
        }

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }
    }
}

// 1위 정답 - https://www.acmicpc.net/source/10340416
class BOJ15988Answer {

    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        dp = new long[1000001];

        dp[1] = 1;
        dp[2] = dp[1] + 1;
        dp[3] = dp[1] + dp[2] + 1;

        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            bw.write(String.valueOf(dp[N]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

}