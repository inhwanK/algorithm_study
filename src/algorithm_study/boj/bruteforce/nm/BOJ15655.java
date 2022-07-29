package algorithm_study.boj.bruteforce.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (6) - https://www.acmicpc.net/problem/15655
public class BOJ15655 {
    public static int n, m;
    public static int[] arr;
    public static int[] result;

    public static StringTokenizer st;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        result = new int[m];
        permutation(0, 0);
        System.out.println(sb);
    }

    public static void permutation(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < n; i++) {
            result[depth] = arr[i];
            permutation(depth + 1, i + 1);
        }
    }
}
