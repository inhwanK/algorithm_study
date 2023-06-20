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


    }
}
