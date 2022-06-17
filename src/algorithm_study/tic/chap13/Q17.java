package algorithm_study.tic.chap13;

import java.util.Scanner;

// 경쟁적 전염
public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int s = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // s초 만큼 반복
            // 수를 증가시키면서 바이러스 찾기

                // 증식하기 전 체크
                    // 시험관을 벗어나는지 확인
                    // 바이러스 존재 여부 확인

                // true 일 경우 증식

    }
}
