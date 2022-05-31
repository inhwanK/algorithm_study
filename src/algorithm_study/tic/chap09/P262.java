package algorithm_study.tic.chap09;

import java.util.Arrays;
import java.util.Scanner;

// [이코테] 전보 풀이 코드
public class P262 {

    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int startPoint = sc.nextInt();
            int endPoint = sc.nextInt();
            int time = sc.nextInt();

            arr[startPoint][endPoint] = time;
        }

        int[] path = new int[n + 1];
        Arrays.fill(path, INF);
        path[c] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int count = 0;
        int totalTime = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[c][i] < INF) {
                count++;
                if (totalTime < arr[c][i]) {
                    totalTime = arr[c][i];
                }
            }
        }

        System.out.println(count - 1 + " " + totalTime);
    }
}