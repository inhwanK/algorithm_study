package algorithm_study.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 미로 탐색 - https://www.acmicpc.net/problem/2178
public class BOJ2178 {

    static class Point {
        int x;
        int y;
        int index;

        public Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = line[j] - '0';
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] visited = new boolean[n][m];
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0, 1));

        while (!que.isEmpty()) {
            Point now = que.poll();

            if (now.x == n - 1 && now.y == m - 1) {
                System.out.println(now.index);
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                que.add(new Point(nx, ny, now.index + 1));
            }
        }
    }
}