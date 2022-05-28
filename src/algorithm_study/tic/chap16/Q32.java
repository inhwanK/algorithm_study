package algorithm_study.tic.chap16;

import java.util.Scanner;

public class Q32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Math.max(arr[i][j] + arr[i + 1][j], arr[i][j] + arr[i + 1][j + 1]);
            }
        }
        int result = arr[0][0];
        System.out.println("결과는 > " + result);
    }
}