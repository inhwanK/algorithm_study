package algorithm_study.boj.basicmath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부녀회장이 될테야 - https://www.acmicpc.net/problem/2775
public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] board = new int[15][14];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 14; j++) {
                if (i == 0) board[i][j] = j + 1;
                else {
                    int sum = 0;
                    for (int k = 0; k <= j; k++) {
                        sum += board[i - 1][k];
                    }
                    board[i][j] = sum;
                }
            }
        }
        
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            if (n == 1) System.out.println(1);
            else System.out.println(board[k][n - 1]);
        }
    }
}

// 바로 앞 집과 바로 밑 층집만 계산하면 되는 거 였군요?
// 1위 정답 - acmicpc.net/source/9775892
class BOJ2775Answer {
    private static int[][] resident = new int[15][15];
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        num();

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(resident[k][n - 1]).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    private static void num() {
        for (int i = 0; i < 15; i++) {
            resident[i][0] = 1;
            resident[0][i] = i + 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                resident[i][j] = resident[i][j - 1] + resident[i - 1][j];
            }
        }
    }
}