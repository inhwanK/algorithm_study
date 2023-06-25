package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 로봇 청소기 - https://www.acmicpc.net/problem/14503
public class BOJ14503 {
    static int n, m, answer;
    static int[][] map;
    static boolean[][] cleanRoom;

    public static void main(String[] args) throws IOException {
        // 주석으로 decision tree 작성하면서 풀기...
        // 방 n, m 크기의 직사각형
        // 청소기가 바라보는 방향 동, 서, 남, 북
        // 방의 각 칸 (r, c)
        // 빈 칸은 전부 청소되지 않은 상태

        // 현재 칸이 아직 청소되지 않았으면 청소,
        // 주변 4칸 중 청소되지 않은 칸 없는 경우
        // 바라보는 방향 유지한 채로 후진,
        // 후진 안되면 작동 멈춤
        // 청소되지 않은 칸 있는 경우
        // 반시계방향으로 회전
        // 바라보는 방향 기준 앞쪽 칸이 청소되지 않은 빈칸이면 전진.
        // 아니면 다시 회전

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        String[] first = br.readLine().split(" ");
        int r = Integer.parseInt(first[0]);
        int c = Integer.parseInt(first[1]);
        int d = Integer.parseInt(first[2]); // 북, 동, 남, 서

        map = new int[n][m];
        cleanRoom = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if (map[i][j] == 1) {
                    cleanRoom[i][j] = true;
                }
            }
        }

        // 청소 알고리즘
        clean(r, c, d);
    }

    private static void clean(int r, int c, int d) {
        // 현재 칸 확인
        if (!cleanRoom[r][c]) {
            // 청소
            answer++;
            cleanRoom[r][c] = true;
        }

        boolean flag = detected(r, c);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // 빈칸 있는 경우
        if (!flag) {
            int cd = d - 2 < 0 ? 4 + (d - 2) : d - 2;

            int nr = r + dr[cd];
            int nc = c + dc[cd];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m || map[nr][nc] == 1) {
                System.out.println(answer);
                return;
            } else {
                clean(nr, nc, d);
            }

        } else { // 없는 경우
            // 회전
            d = d - 1 < 0 ? 3 : d - 1;

            int nr = r + dr[d];
            int nc = c + dc[d];

            // 바라보는 방향 범위 벗어나는지 아닌지 확인, 바라보는 방향 청소되지 않은 빈칸인지 확인
            if (nr < 0 || nr >= n || nc < 0 || nc >= m || cleanRoom[nr][nc]) {
                clean(r, c, d);
            } else {
                clean(nr, nc, d);
            }
        }

    }

    private static boolean detected(int r, int c) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // 주변 4칸 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }

            if (!cleanRoom[nr][nc]) {
                return true;
            }
        }
        return false;
    }
}