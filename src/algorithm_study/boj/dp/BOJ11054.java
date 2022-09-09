package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분 수열 - https://www.acmicpc.net/problem/11054
public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] l_dp = new int[n];
        int[] r_dp = new int[n];
        Arrays.fill(l_dp, 1);
        Arrays.fill(r_dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    l_dp[i] = Math.max(l_dp[i], l_dp[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) {
                    r_dp[i] = Math.max(r_dp[i], r_dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, l_dp[i] + r_dp[i] - 1);
        }
        System.out.println(result);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/46967123
class BOJ11054Answer {

    private static final int INF = Integer.MAX_VALUE;
    private static int n;
    private static int[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        length = new int[n];
        Arrays.fill(length, INF);

        int[] order = new int[n];
        int[] reverseOrder = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            order[i] = setLocation(arr[i]);
        }
        Arrays.fill(length, INF);

        for (int i = n - 1; i >= 0; i--) {
            reverseOrder[i] = setLocation(arr[i]);
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, order[i] + reverseOrder[i]-1);
        }
        System.out.println(max);
    }

    private static int setLocation(int now) {
        int l = 0;
        int r = n;

        while (l < r) {
            int mid = (l + r) / 2;
            if (length[mid] >= now)
                r = mid;
            else
                l = mid + 1;
        }
        length[l] = now;
        return l + 1;
    }
}