package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 - https://www.acmicpc.net/problem/11053
public class BOJ11053 {
    public static int n, result, arr[], memo[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        memo = new int[n];
        Arrays.fill(memo, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, memo[i]);
        }
        System.out.println(result);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/4467206
class BOJ11053Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] index = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            index[i] = Integer.MAX_VALUE;
        }


        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] > index[idx]) {
                idx++;
                index[idx] = arr[i];
                continue;
            }
            for (int j = idx; j > 0; j--) {
                if (arr[i] < index[j] && arr[i] > index[j - 1]) {
                    index[j] = arr[i];
                }
            }
        }
        System.out.println(idx);
    }
}