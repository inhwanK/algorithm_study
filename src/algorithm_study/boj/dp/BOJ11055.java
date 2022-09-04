package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 증가 부분 수열 - https://www.acmicpc.net/problem/11055
public class BOJ11055 {
    public static int n, result, arr[], dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        dp = new int[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        dp[0] = 0;
        result = dp[1] = arr[1];


        for (int i = 2; i <= n; i++) {
            dp[i] = arr[i];
            for (int j = i - 1; j > 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}

// 풀이 비슷함
// 상위 정답 - https://www.acmicpc.net/source/15068592
class BOJ11055Answer {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());

        int[] arr = new int[1001];
        int[] dp = new int[1001];  //  dp[i] : arr[i]를 끝원소로 갖는 LIS의 최대합

        for (int i = 1; i <= N; i++) {  //  INPUT
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp[1] = arr[1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + arr[i]) {
                        dp[i] = dp[j] + arr[i];
                    }
                }
            }
        }

        int max = dp[1];
        for (int i = 2; i <= N; i++)
            if (max < dp[i]) max = dp[i];

        System.out.println(max);

    }
}