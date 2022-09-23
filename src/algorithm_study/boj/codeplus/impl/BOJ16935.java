package algorithm_study.boj.codeplus.impl;

import java.util.*;
import java.io.*;

// 배열 돌리기 3 - https://www.acmicpc.net/problem/16935
public class BOJ16935 {
    public static int n, m, r, num, arr[][];

    public static void main(String[] args) throws IOException {
        // 구현문제 개같네...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < r; i++) {
            switch (num) {
                case (1):
                    one();
                    break;
                case (2):
                    two();
                    break;
                case (3):
                    three();
                    break;
                case (4):
                    four();
                    break;
                case (5):
                    five();
                    break;
                case (6):
                    six();
                    break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

            }
        }
    }

    public static void one() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp[i] = arr[n - i - 1];
        }

        arr = temp;
    }

    public static void two() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = arr[i][m - j - 1];
            }
        }

        arr = temp;
    }

    public static void three() {
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[n - j - 1][i];
            }
        }

        arr = temp;
    }

    public static void four() {
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[j][m - i - 1];
            }
        }

        arr = temp;
    }

    public static void five() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i][j + m / 2] = arr[i][j];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i + n / 2][j + m / 2] = arr[i][j + m / 2];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i + n / 2][j] = arr[i + n / 2][j + m / 2];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i][j] = arr[i + n / 2][j];
            }
        }

        arr = temp;
    }

    public static void six() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i][j] = arr[i][j + m / 2];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i + n / 2][j] = arr[i][j];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i + n / 2][j + m / 2] = arr[i + n / 2][j];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i][j + m / 2] = arr[i + n / 2][j + m / 2];
            }
        }

        arr = temp;
    }
}
