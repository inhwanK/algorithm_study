package algorithm_study.boj.codeplus.permutation;

import java.io.*;

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

// 정답 - https://lotuslee.tistory.com/m/92?category=848933
class BOJ10971Answer {
    static int N;
    static int[][] w;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        w = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            String[] sarr = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                w[i][j] = Integer.parseInt(sarr[j - 1]);
            }
        }

        visited[1] = true;
        dfs(1, 1, 1, 0);

        bw.write(min + "\n");
        bw.flush();
    }

    public static void dfs(int start, int now, int cnt, int cost) {

        if (now == start && cost > 0) {
            min = Math.min(min, cost);
            return;
        }

        for (int n = 1; n <= N; n++) {
            if (w[now][n] > 0) {
                if (n == start && cnt == N) {
                    cost += w[now][n];
                    dfs(start, n, cnt + 1, cost);
                } else if (!visited[n]) {
                    visited[n] = true;
                    cost += w[now][n];
                    dfs(start, n, cnt + 1, cost);
                    cost -= w[now][n];
                    visited[n] = false;
                }
            }
        }
    }

}