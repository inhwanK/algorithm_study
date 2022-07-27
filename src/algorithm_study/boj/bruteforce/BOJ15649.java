package algorithm_study.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N과 M (1) - https://www.acmicpc.net/problem/15649
public class BOJ15649 {
    public static int n, m;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        visited = new boolean[n + 1];

        int[] result = new int[m];
        permutation(0, result);
        System.out.println(sb);
    }

    // 순열...
    public static void permutation(int depth, int[] result) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permutation(depth + 1, result);
                visited[i] = false;
            }
        }
    }
}