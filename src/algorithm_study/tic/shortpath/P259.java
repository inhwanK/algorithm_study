package algorithm_study.tic.shortpath;

import java.util.Arrays;
import java.util.Scanner;

// [이코테] 미래 도시 개인 풀이
public class P259 {

    static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            arr[row][col] = 1;
            arr[col][row] = 1;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int pass = 1; pass < n + 1; pass++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][pass] + arr[pass][j]);
                    arr[j][i] = arr[i][j];
                }
            }
        }

        int result = arr[1][k] + arr[k][x];
        if (result >= INF) {
            result = -1;
        }

        System.out.println(result);
    }
}
