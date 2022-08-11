package algorithm_study.boj.bitmask;

import java.util.*;
import java.io.*;

// 종이 조각 - https://www.acmicpc.net/problem/14391
public class BOJ14391 {
    public static int x, y, arr[][];
    public static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        arr = new int[x][y];
        visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            String row = br.readLine();
            for (int j = 0; j < y; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }
        // 가창 큰 수 조진 다음에
        // 그 다음 가장 큰 수, 그다음 가장 큰 수 ....

        // 처음 가장 큰 수를 찾기 위해서는...
        // String으로 받은 다음 Integer로 변환
        // 처음부터 0이 나온다면?
    }

    public static void dfs(int depth) {
        if(depth == x) {
            return;
        }


    }
}
