package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간초과
// 1, 2, 3 더하기 5 - https://www.acmicpc.net/problem/15990
public class BOJ15990_1 {
    public static int n;
    public static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            count = 0;
            n = Integer.parseInt(br.readLine());
            for (int j = 1; j <= 3; j++) {
                dfs(0, j);
            }
            count = count % 1000000009;
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int value, int add) {
        value = value + add;

        if (value > n) return;
        if (value == n) {
            count++;
            return;
        }

        if (add != 1) dfs(value, 1);
        if (add != 2) dfs(value, 2);
        if (add != 3) dfs(value, 3);
    }
}

// 2차원 배열로 dp를 만드는 경우도 있구나!
class BOJ15990_2 {
    public static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        arr = new long[100001][4];
        arr[1][1] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 1;

        for (int i = 4; i < arr.length; i++) {
            arr[i][1] = (arr[i - 1][2] + arr[i - 1][3]) % 1000000009;
            arr[i][2] = (arr[i - 2][1] + arr[i - 2][3]) % 1000000009;
            arr[i][3] = (arr[i - 3][1] + arr[i - 3][2]) % 1000000009;
        }

        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            long sum = (arr[n][1] + arr[n][2] + arr[n][3]) % 1000000009;
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}

// 1위 정답 - https://www.acmicpc.net/source/25259864
class BOJ15990Answer {
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] dist = makeTable();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int cur = (((dist[1][N] + dist[2][N]) % MOD) + dist[3][N]) % MOD;
            sb.append(cur).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    private static int[][] makeTable() {
        int[][] dist = new int[4][100001];
        dist[1][1] = 1; dist[2][2] = 1; dist[1][3] = 1; dist[2][3] = 1; dist[3][3] = 1;

        for (int i = 4; i < 100001; i++) {
            dist[1][i] = (dist[2][i - 1] + dist[3][i - 1]) % MOD;
            dist[2][i] = (dist[1][i - 2] + dist[3][i - 2]) % MOD;
            dist[3][i] = (dist[1][i - 3] + dist[2][i - 3]) % MOD;
        }

        return dist;
    }
}