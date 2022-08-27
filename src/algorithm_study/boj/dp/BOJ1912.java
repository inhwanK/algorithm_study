package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

// 연속합 - https://www.acmicpc.net/problem/1912
public class BOJ1912 {
    public static int n, result, dp[], arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = arr[0];
        result = arr[0];

        dp(n - 1);
        System.out.println(result);
    }

    public static int dp(int n) {
        if (dp[n] == Integer.MIN_VALUE) {
            dp[n] = Math.max(dp(n - 1) + arr[n], arr[n]);

            result = Math.max(result, dp[n]);
        }

        return dp[n];
    }
}

// 상위 정답 - https://www.acmicpc.net/source/7194453
class BOJ1912Answer {
    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        st.nextToken();
        int n = (int) st.nval;

        int[] ar = new int[n];
        int[] mAr = new int[n];

        for (int i = 0; i < n; i++) {
            st.nextToken();
            ar[i] = (int) st.nval;
            mAr[i] = 0;
        }

        mAr[0] = ar[0];
        for (int i = 1; i < n; i++) {
            if (ar[i] > ar[i] + mAr[i - 1]) {
                mAr[i] = ar[i];
            } else {
                mAr[i] = ar[i] + mAr[i - 1];
            }
        }

        int max = -1000;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, mAr[i]);
        }
        System.out.println(max);
    }
}