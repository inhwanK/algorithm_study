package algorithm_study.boj.bruteforce.recursion;

import java.util.*;
import java.io.*;

// 스타트와 링크 - https://www.acmicpc.net/problem/14889
public class BOJ14889 {
    public static int n;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        // n 명 중 n / 2 개를 뽑는 조합 (중복 안됨)
        // n / 2 명을 둘 씩 짝지어서 점수를 계산
        // 두 팀의 차이가 가장 작은 값 저장

        // dfs가 두번?
    }
}
