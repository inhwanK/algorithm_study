package algorithm_study.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// 단지 번호 붙이기 - https://www.acmicpc.net/problem/2667
public class BOJ2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {

            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = line[j] - '0';
            }
        }

        int index = 0;
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    int count = bfs(i, j, board, visited);
                    list.add(count);
                    index++;
                }
            }
        }

        System.out.println(index);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static int bfs(int i, int j, int[][] board, boolean[][] visited) {
        Queue<int[]> que = new LinkedList<int[]>();
        int[] start = {i, j};
        que.add(start);
        visited[i][j] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int count = 0;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];

                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (board[nx][ny] != 1) {
                    continue;
                }

                visited[nx][ny] = true;
                int[] a = {nx, ny};
                que.add(a);
            }

            count++;
        }

        return count;
    }
}
