package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 4 - https://www.acmicpc.net/problem/14002
public class BOJ14002 {
    public static int n, result, memo[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        memo = new int[n + 1][2];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            memo[i + 1][1] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i <= n; i++) {
            memo[i][0] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (memo[i][1] > memo[j][1] & memo[i][0] <= memo[j][0]) {
                    memo[i][0] = memo[j][0] + 1;
                }
            }
            result = Math.max(result, memo[i][0]);
        }
        sb.append(result).append('\n');

        int[] arr = new int[result];
        for (int i = n; i > 0; i--) {

            if (memo[i][0] == result) {
                arr[result - 1] = memo[i][1];
                result--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}

// 스택을 이용해서 요소를 빼는 방법
// https://loosie.tistory.com/388
class BOJ14002Answer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int lis = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lis + "\n");

        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lis) {
                s.push(arr[i]);
                lis--;
            }
        }

        while (!s.isEmpty()) {
            sb.append(s.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}