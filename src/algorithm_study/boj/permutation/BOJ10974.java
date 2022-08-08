package algorithm_study.boj.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 모든 순열 - https://www.acmicpc.net/problem/10974
public class BOJ10974 {
    public static int n, arr[];
    public static boolean visited[];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n + 1];
        permutation(0);
        System.out.println(sb);
    }

    static void permutation(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}