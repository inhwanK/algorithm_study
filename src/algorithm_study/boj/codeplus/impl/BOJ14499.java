package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주사위 굴리기 - https://www.acmicpc.net/problem/14499
public class BOJ14499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        int y = Integer.parseInt(input[3]);
        int k = Integer.parseInt(input[4]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        Dice curDice = new Dice(0, 1, 2, 3, 4, 5);
        int[] dice = new int[6];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        String[] move = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(move[i]) - 1;

            int t = curDice.top;
            int u = curDice.up;
            int d = curDice.down;
            int l = curDice.left;
            int r = curDice.right;
            int b = curDice.bottom;

            Dice nextDice;

            if (dir == 0) {
                nextDice = new Dice(l, u, d, b, t, r);
            } else if (dir == 1) {
                nextDice = new Dice(r, u, d, t, b, l);
            } else if (dir == 2) {
                nextDice = new Dice(d, t, b, l, r, u);
            } else {
                nextDice = new Dice(u, b, t, l, r, d);
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            curDice = nextDice;
            x = nx;
            y = ny;

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[nextDice.bottom];
            } else {
                dice[nextDice.bottom] = map[nx][ny];
                map[nx][ny] = 0;
            }

            System.out.println(dice[nextDice.top]);
        }

    }

    static class Dice {
        int top, up, down, left, right, bottom;

        public Dice(int top, int up, int down, int left, int right, int bottom) {
            this.top = top;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }
    }
}