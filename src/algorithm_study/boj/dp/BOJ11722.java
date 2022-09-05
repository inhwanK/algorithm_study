package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 감소하는 부분 수열 - https://www.acmicpc.net/problem/11722
public class BOJ11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/12527854
class BOJ11722Answer {

    public static void main(String args[]) throws IOException {
        int ai[] = new int[1111];
        int D[] = new int[1111];
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 수열의 크기

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            ai[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < D.length; j++) {
                if (D[j] <= ai[i]) {
                    D[j] = ai[i];
                    break;
                }
            }
        }

        for (int j = 0; j < D.length; j++) {
            if (D[j] > 0) {
                count++;
            }
        }
        System.out.println(count);

    }
}