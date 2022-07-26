package algorithm_study.boj.bruteforce;

import java.util.*;
import java.io.*;

// 테트로미노 - https://www.acmicpc.net/problem/14500
public class BOJ14500 {
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

            }
        }
    }

    public static boolean validCheck(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        return true;
    }

    public static int rotateSum() {
        int sum = 0;

        return sum;
    }

    public static int symSum() {
        return 0;
    }
}

class Tetromino {
    int[] x = new int[4];
    int[] y = new int[4];

    public void setX(int one, int two, int three, int four) {

    }
}

