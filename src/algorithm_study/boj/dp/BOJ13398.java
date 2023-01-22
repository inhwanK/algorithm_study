package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

    public static void answer1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        int ans = num[0];
        int[][] dp = new int[2][N];
        dp[0][0] = num[0];
        dp[1][0] = num[0];

        for (int i = 1; i < N; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] + num[i], num[i]);
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + num[i]);

            int temp = Math.max(dp[0][i], dp[1][i]);
            if (temp > ans)
                ans = temp;
        }

        System.out.print(ans);
        br.close();
    }
}