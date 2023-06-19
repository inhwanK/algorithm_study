package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 배열 돌리기 1 - https://www.acmicpc.net/problem/16926
public class BOJ16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        int[][] board = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        ArrayList<Queue<Integer>> list = new ArrayList<>();

        int count = 0;
        while (true) {
            if (visited[count][count] != 0) {
                break;
            }
            list.add(insert(count, count, board, visited));
            count++;
        }

        count = 0;
        for (int i = 0; i < list.size(); i++) {
            Queue<Integer> now = list.get(i);
            for (int j = 0; j < r; j++) {
                now.add(now.poll());
            }

            reversInsert(count, count, board, visited, now);
            count++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static Queue<Integer> insert(int x, int y, int[][] board, int[][] visited) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Integer> que = new LinkedList<>();
        que.add(board[x][y]);
        visited[x][y] = 1;

        for (int dir = 0; dir < 4; dir++) {

            while (true) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                    break;
                }

                if (visited[nx][ny] != 0) {
                    break;
                }

                visited[nx][ny] = 1;
                que.add(board[nx][ny]);

                x = nx;
                y = ny;
            }
        }

        return que;
    }

    private static void reversInsert(int x, int y, int[][] board, int[][] visited, Queue<Integer> now) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        board[x][y] = now.poll();
        visited[x][y] = 2;

        for (int dir = 0; dir < 4; dir++) {

            while (true) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                    break;
                }

                if (visited[nx][ny] != 1) {
                    break;
                }

                visited[nx][ny] = 2;
                board[nx][ny] = now.poll();

                x = nx;
                y = ny;
            }
        }
    }
}