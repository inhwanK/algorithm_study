package algorithm_study.boj.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 테트로미노 - https://www.acmicpc.net/problem/14500
public class BOJ14500 {
    public static int n, m;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int result = 0;

    public static int[][] arr;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                initMaxValue(1, i, j, arr[i][j]);
                visited[i][j] = true;
                calculateMaxValue(1, i, j, arr[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(result);
    }

    public static void calculateMaxValue(int depth, int x, int y, int sum) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                sum += arr[nx][ny];
                calculateMaxValue(depth + 1, nx, ny, sum);
                sum -= arr[nx][ny];
                visited[nx][ny] = false;
            }
        }
    }

    public static void initMaxValue(int depth, int x, int y, int sum) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                sum += arr[nx][ny];
                initMaxValue(depth + 1, x, y, sum);
                sum -= arr[nx][ny];
                visited[nx][ny] = false;
            }
        }
    }
}