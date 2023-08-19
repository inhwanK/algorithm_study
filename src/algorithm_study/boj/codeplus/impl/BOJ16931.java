package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 겉넓이 구하기 - https://www.acmicpc.net/problem/16931
public class BOJ16931 {
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        answer = new int[x][y];
        int[][] board = new int[x][y];
        for (int i = 0; i < x; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 0) {
                    continue;
                }
                answer[i][j] = 2;
            }
        }

        int result = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result += search(board, i, j);
            }
        }

        System.out.println(result);
    }

    public static int search(int[][] board, int i, int j) {
        int now = board[i][j];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                answer[i][j] += board[i][j];
                continue;
            }

            if (now >= board[nx][ny]) {
                continue;
            }

            answer[i][j] += board[nx][ny] - now;

        }
        return answer[i][j];
    }
}