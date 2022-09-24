package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        String[] nums = br.readLine().split(" ");
        int[] numArr = new int[r];
        for(int i = 0; i < r; i++) {
            numArr[i] = Integer.parseInt(nums[i]);
        }
        for (int i = 0; i < r; i++) {
            switch (numArr[i]) {
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
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void one() {
        int[][] temp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[arr.length - i - 1];
        }

        arr = temp;
    }

    public static void two() {
        int[][] temp = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[i][j] = arr[i][arr[0].length - j - 1];
            }
        }

        arr = temp;
    }

    public static void three() {
        int[][] temp = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[arr.length - j - 1][i];
            }
        }

        arr = temp;
    }

    public static void four() {
        int[][] temp = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[j][arr[0].length - i - 1];
            }
        }

        arr = temp;
    }

    public static void five() {
        int x = arr.length;
        int y = arr[0].length;
        int[][] temp = new int[x][y];

        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y / 2; j++) {
                temp[i][j + y / 2] = arr[i][j];
            }
        }

        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y / 2; j++) {
                temp[i + x / 2][j + y / 2] = arr[i][j + y / 2];
            }
        }

        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y / 2; j++) {
                temp[i + x / 2][j] = arr[i + x / 2][j + y / 2];
            }
        }

        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y / 2; j++) {
                temp[i][j] = arr[i + x / 2][j];
            }
        }

        arr = temp;
    }

    public static void six() {
        int x = arr.length;
        int y = arr[0].length;

        int[][] temp = new int[x][y];

        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y / 2; j++) {
                temp[i][j] = arr[i][j + y / 2];
            }
        }

        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y / 2; j++) {
                temp[i + x / 2][j] = arr[i][j];
            }
        }

        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y / 2; j++) {
                temp[i + x / 2][j + y / 2] = arr[i + x / 2][j];
            }
        }

        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y / 2; j++) {
                temp[i][j + y / 2] = arr[i + x / 2][j + y / 2];
            }
        }

        arr = temp;
    }
}