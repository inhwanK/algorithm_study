package algorithm_study.boj;

import java.io.*;

// 구간 합 구하기 5 - https://www.acmicpc.net/problem/11660
public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(line[j - 1]) + arr[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int rowStart = Integer.parseInt(line[0]);
            int rowEnd = Integer.parseInt(line[2]);
            int colStart = Integer.parseInt(line[1]) - 1;
            int colEnd = Integer.parseInt(line[3]);

            int sum = 0;
            for(int j = rowStart; j <= rowEnd; j++) {
                sum += arr[j][colEnd] - arr[j][colStart];
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}