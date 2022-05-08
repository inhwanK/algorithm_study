package algorithm_study.tic.chap16;

import java.util.*;

/*
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
* */
public class P375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        int count = 0;
        while (count < t) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                    System.out.println(arr[i][j]);
                }
            }

            for (int j = 1; j < n - 1; j++) {
                for (int i = 0; i < m - 1; i++) {
                    arr[i + 1][j] = Math.max(arr[i][j] + arr[i + 1][j], arr[i + 1][j]);
                    arr[i + 1][j - 1] = Math.max(arr[i][j] + arr[i + 1][j - 1], arr[i + 1][j - 1]);
                    arr[i + 1][j + 1] = Math.max(arr[i][j] + arr[i + 1][j + 1], arr[i + 1][j + 1]);
                }
            }

            for (int i = 0; i < m - 1; i++) {
                arr[i + 1][0] = Math.max(arr[i][0] + arr[i + 1][0], arr[i + 1][0]);
                arr[i + 1][1] = Math.max(arr[i][0] + arr[i + 1][1], arr[i + 1][1]);
            }

            for (int i = 0; i < m - 1; i++) {
                arr[i + 1][n - 1] = Math.max(arr[i][n - 1] + arr[i + 1][n - 1], arr[i + 1][n - 1]);
                arr[i + 1][n - 2] = Math.max(arr[i][n - 1] + arr[i + 1][n - 2], arr[i + 1][n - 2]);
            }

            count++;
        }
    }

    static int max(int up, int same, int down) {
        int max = 0;

        if (up > same) {
            if (down > up) {
                max = down;
            } else {
                max = up;
            }
        } else {
            if (same > down) {
                max = same;
            } else {
                max = down;
            }
        }

        return max;
    }
}
