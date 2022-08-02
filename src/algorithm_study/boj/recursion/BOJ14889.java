package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크 - https://www.acmicpc.net/problem/14889
public class BOJ14889 {
    public static int n, start = 0, link = 0, result = Integer.MAX_VALUE;
    public static int[][] board;
    public static boolean[] persons;
    public static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        persons = new boolean[n + 1];
        score = new int[2];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        personCombination(0, 1);
        System.out.println(result);
    }

    // 팀을 나누는 경우의 수 구하기.
    public static void personCombination(int depth, int first) {
        if (depth == n / 2) {
            result = Math.min(calculateMemberScore(), result);
            start = link = 0;
            return;
        }

        for (int i = first; i <= n; i++) {
            persons[i] = true;
            personCombination(depth + 1, i + 1);
            persons[i] = false;
        }
    }

    // 나눠지는 팀에 따라 스코어 계산
    public static int calculateMemberScore() {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (persons[i] && persons[j]) {
                    start += board[i - 1][j - 1] + board[j - 1][i - 1];
                }
                if (!persons[i] && !persons[j]) {
                    link += board[i - 1][j - 1] + board[j - 1][i - 1];
                }
            }
        }

        return Math.abs(start - link);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/37713019
class BOJ14889Answer {
    static int N, S[], A[][]; // 이렇게 선언도 되는구나.....
    static boolean[] check;

    static int answer = Integer.MAX_VALUE, total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                total += (A[i][j] = Integer.parseInt(st.nextToken()));
        }

        S = new int[N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                S[i] += A[i][j] + A[j][i];

        check = new boolean[N];
        dfs(-1, 0);
        System.out.println(answer);
    }

    static void dfs(int n, int m) {
        if (m == N / 2) {
            int temp = 0;
            for (int i = 0; i < N; i++)
                if (check[i])
                    temp += S[i];
            answer = Math.min(answer, Math.abs(total - temp));
            return;
        }

        for (int i = n + 1, j = N / 2 + m; i <= j; i++) {
            check[i] = true;
            dfs(i, m + 1);
            check[i] = false;
        }
    }
}