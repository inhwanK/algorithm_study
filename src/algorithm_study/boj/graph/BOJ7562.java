package algorithm_study.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 나이트의 이동 - https://www.acmicpc.net/problem/7562
public class BOJ7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[][] board = new int[size][size];

            String[] start = br.readLine().split(" ");
            String[] arrive = br.readLine().split(" ");

            int sx = Integer.parseInt(start[0]);
            int sy = Integer.parseInt(start[1]);

            int ax = Integer.parseInt(arrive[0]);
            int ay = Integer.parseInt(arrive[1]);

            bfs(sx, sy, ax, ay, board);
            System.out.println(board[ax][ay]);
        }
    }

    private static void bfs(int i, int j, int ai, int aj, int[][] board) {
        Queue<int[]> que = new LinkedList<>();
        int[] first = {i, j};
        que.add(first);

        int[] dx = {2, 2, 1, 1, -2, -2, -1, -1};
        int[] dy = {1, -1, 2, -2, 1, -1, 2, -2};

        while (!que.isEmpty()) {
            int[] now = que.poll();

            int x = now[0];
            int y = now[1];
            if(x == ai && y == aj) {
                break;
            }

            int index = board[x][y];

            for (int dir = 0; dir < 8; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    board[nx][ny] = index + 1;
                    int[] next = {nx, ny};
                    que.add(next);
                }
            }
        }

        return;
    }
}
