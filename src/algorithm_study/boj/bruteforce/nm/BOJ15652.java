package algorithm_study.boj.bruteforce.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N과 M (4) - https://www.acmicpc.net/problem/15652
public class BOJ15652 {
    public static int n, m;
    public static StringBuilder sb;
    public static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        sb = new StringBuilder();

        result = new char[m];
        permutation(0, 1);
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

        for (int i = start; i <= n; i++) {
            result[depth] = (char) (i + '0');
            permutation(depth + 1, i);
        }
    }
}
