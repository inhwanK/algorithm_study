package algorithm_study.boj.bruteforce.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (8) - https://www.acmicpc.net/problem/15657
public class BOJ15657 {
    public static int n, m;
    public static int[] result, arr;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result = new int[m];
        dupPermutation(0, 0);
        System.out.println(sb);
    }

    public static void dupPermutation(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            result[depth] = arr[i];
            dupPermutation(depth + 1, i);
        }
    }
}