package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 경사로 - https://www.acmicpc.net/problem/14890
public class BOJ14890 {
    static int n, l;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        l = Integer.parseInt(input[1]);

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (calRow(i)) {
                count++;
            }
            if (calCol(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean calRow(int row) {
        boolean[] runwayMap = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int dis = map[row][i] - map[row][i + 1];
            if (dis > 1 || dis < -1) {
                return false;
            } else if (dis == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || runwayMap[i - j]) return false;
                    if (map[row][i] != map[row][i - j]) return false;
                    runwayMap[i - j] = true;
                }
            } else if (dis == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || runwayMap[i + j]) return false;
                    if (map[row][i] - 1 != map[row][i + j]) return false;
                    runwayMap[i + j] = true;
                }
            }
        }

        return true;
    }

    private static boolean calCol(int col) {
        boolean[] runwayMap = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int dis = map[i][col] - map[i + 1][col];
            if (dis > 1 || dis < -1) {
                return false;
            } else if (dis == -1) {
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || runwayMap[i - j]) return false;
                    if (map[i][col] != map[i - j][col]) return false;
                    runwayMap[i - j] = true;
                }
            } else if (dis == 1) {
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || runwayMap[i + j]) return false;
                    if (map[i][col] - 1 != map[i + j][col]) return false;
                    runwayMap[i + j] = true;
                }
            }
        }

        return true;
    }
}