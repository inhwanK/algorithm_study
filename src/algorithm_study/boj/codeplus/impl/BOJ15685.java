package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 드래곤 커브 - https://www.acmicpc.net/problem/15685
public class BOJ15685 {
    static boolean[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        // 드래곤 커브는 격자 밖으로 벗어나지 않음. 서로 겹칠 수 있음.
        // 시계 방향으로 90도 이동한 후 그 전 세대 커브를 이어붙임.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);
            int g = Integer.parseInt(line[3]);

            // 드래곤 커브 그리기
            drawDragonCurb(y, x, d, g);
        }

        // 정사각형 탐색
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void drawDragonCurb(int y, int x, int d, int g) {
        ArrayList<Integer> dir = new ArrayList<>();
        dir.add(d);
        for (int i = 0; i < g; i++) {
            for (int j = dir.size() - 1; j >= 0; j--) {
                dir.add((dir.get(j) + 1) % 4);
            }
        }
        map[y][x] = true;
        for (int i = 0; i < dir.size(); i++) {
            y += dy[dir.get(i)];
            x += dx[dir.get(i)];
            map[y][x] = true;
        }
        return;
    }
}