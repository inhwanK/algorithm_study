package algorithm_study.tic.chap17;

import java.util.Arrays;
import java.util.Scanner;

/*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
*/
// 정확한 순위
public class Q38 {

    static final int INF = 999999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int col = sc.nextInt();
            int row = sc.nextInt();

            arr[col][row] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if(arr[i][j] != INF || arr[j][i] != INF){
                    count++;
                }
            }
            if(count == m){
                result++;
            }
        }

        System.out.println();
        System.out.println("result > " + result);

    }
}