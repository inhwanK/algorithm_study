package algorithm_study.boj.codeplus.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs를 할 때는 트리 한쪽으로 치우처진 간선을 먼저 탐색하는 경우를 생각해보면 쉬움
// 종이 조각 - https://www.acmicpc.net/problem/14391
public class BOJ14391 {
    public static int n, m, result, arr[][];
    public static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int row, int j) {
        if (row >= n) {
            sum();
            return;
        }

        if (j >= m) {
            dfs(row + 1, 0);
            return;
        }
        visited[row][j] = true;
        dfs(row, j + 1);
        visited[row][j] = false;
        dfs(row, j + 1);
    }

    public static void sum() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tSum = 0;
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    tSum *= 10;
                    tSum += arr[i][j];
                } else {
                    sum += tSum;
                    tSum = 0;
                }
            }
            sum += tSum;
        }

        for (int i = 0; i < m; i++) {
            int tSum = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j][i]) {
                    tSum *= 10;
                    tSum += arr[j][i];
                } else {
                    sum += tSum;
                    tSum = 0;
                }
            }
            sum += tSum;
        }

        result = Math.max(result, sum);
    }
}

// N * M 2차원 배열을 N * M 크기 1차원 배열로 바꿔서 dfs 메서드를 간단하게 구현
// 더하기 연산 할 때, 이러한 점을 고려해야함
// 상위 정답 - https://www.acmicpc.net/source/23707454
class BOJ14391Answer {

    static int N;
    static int M;
    static int[][] paper;
    static int[] answer;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        answer = new int[N * M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = s.charAt(j) - '0';
            }
        }

        go(0);
        System.out.print(max);
    }

    static void go(int index) {

        if (index == N * M) {
            solve();
            return;
        }

        for (int i = 0; i <= 1; i++) {
            answer[index] = i;
            go(index + 1);
        }
    }

    static void solve() {
        int allSum = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < M; j++) {
                if (answer[i * M + j] == 1) {
                    sum = sum * 10 + paper[i][j];
                } else {
                    allSum += sum;
                    sum = 0;
                }
            }
            allSum += sum;
        }

        for (int i = 0; i < M; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                if (answer[j * M + i] == 0) {
                    sum = sum * 10 + paper[j][i];
                } else {
                    allSum += sum;
                    sum = 0;
                }
            }
            allSum += sum;
        }

        if (max < allSum) {
            max = allSum;
        }
    }
}