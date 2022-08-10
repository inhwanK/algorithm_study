package algorithm_study.boj.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 외판원 순회 2 - https://www.acmicpc.net/problem/10971
public class BOJ10971 {
    static int n, first, arr[][];
    static boolean[] visited;
    static long sum, result = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            sum = 0;
            first = i;
            visited[i] = true;
            dfs(0, first);
            visited[i] = false;
        }

        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int depth, int start) {
        if (depth == n - 1 && arr[start][first] != 0) {
            sum += arr[start][first];
            result = Math.min(sum, result);
            sum -= arr[start][first];
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr[start][i] == 0) {
                continue;
            }

            if (!visited[i]) {
                visited[i] = true;
                sum += arr[start][i];
                dfs(depth + 1, i);
                sum -= arr[start][i];
                visited[i] = false;
            }
        }
    }
}