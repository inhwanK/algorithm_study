package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 경사로 - https://www.acmicpc.net/problem/14890
public class BOJ14890 {
    static int n, l;
    static int[][] map;
    static boolean[][] runwayMap;

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

        runwayMap = new boolean[n][n];
        int count = 0;
        for (int row = 0; row < n; row++) {
            if (rowCheck(row)) {
                count++;
            }
        }

        runwayMap = new boolean[n][n];
        for (int col = 0; col < n; col++) {
            if (colCheck(col)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean rowCheck(int row) {
        int size = map.length;
        int now = map[row][0];
        for (int i = 1; i < size; i++) {
            if (now != map[row][i]) {
                if (!rowRunway(row, i)) {
                    return false;
                }
                if (now > map[row][i]) {
                    i += l - 1;
                }
            }
            now = map[row][i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(map[row][i] + " ");
        }
        System.out.println();

        return true;
    }

    private static boolean rowRunway(int row, int start) {
        // 경사로 설치 위치가 범위를 초과하는지 여부
        if (map[row][start] < map[row][start - 1]) {
            if (start + l - 1 >= n) {
                return false;
            }

            int now = map[row][start];
            for (int i = start; i < start + l; i++) {
                if (now != map[row][i]) {
                    return false;
                }
                // 경사로 설치여부
                if (runwayMap[row][i]) {
                    return false;
                }
                now = map[row][i];
            }
            // 경사로 설치
            for (int i = start; i < start + l; i++) {
                runwayMap[row][i] = true;
            }

        } else {

            if (start - l < 0) {
                return false;
            }
            // l 이 1인 경우
            int now = map[row][start - 1];
            for (int i = start - 2; i >= start - l; i--) {
                if (now != map[row][i]) {
                    return false;
                }
                // 경사로 설치여부
                if (runwayMap[row][i]) {
                    return false;
                }
                now = map[row][i];
            }
            // 경사로 설치
            for (int i = start - 1; i >= start - l; i--) {
                runwayMap[row][i] = true;
            }
        }
        return true;
    }

    private static boolean colCheck(int col) {
        int size = map.length;
        int now = map[0][col];
        for (int i = 1; i < size; i++) {
            if (now != map[i][col]) {
                if (!colRunway(col, i)) {
                    return false;
                }
                if (now > map[i][col]) {
                    i += l - 1;
                }
            }
            now = map[i][col];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(map[i][col] + " ");
        }
        System.out.println();

        return true;
    }

    private static boolean colRunway(int col, int start) {
        // 경사로 설치 위치가 범위를 초과하는지 여부
        if (map[start][col] < map[start - 1][col]) {
            if (start + l - 1 >= n) {
                return false;
            }

            int now = map[start][col];
            for (int i = start; i < start + l; i++) {
                if (now != map[i][col]) {
                    return false;
                }
                // 경사로 설치여부
                if (runwayMap[i][col]) {
                    return false;
                }
                now = map[i][col];
            }
            // 경사로 설치
            for (int i = start; i < start + l; i++) {
                runwayMap[i][col] = true;
            }

        } else {

            if (start - l < 0) {
                return false;
            }

            int now = map[start - 1][col];
            for (int i = start - 2; i >= start - l; i--) {
                if (now != map[i][col]) {
                    return false;
                }
                // 경사로 설치여부
                if (runwayMap[i][col]) {
                    return false;
                }
                now = map[i][col];
            }
            // 경사로 설치
            for (int i = start - 1; i >= start - l; i--) {
                runwayMap[i][col] = true;
            }
        }
        return true;
    }
}
