package algorithm_study.boj.bruteforce.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (1) - https://www.acmicpc.net/problem/15649
public class BOJ15649 {
    public static int n, m;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        visited = new boolean[n + 1];

        char[] result = new char[m];
        permutation(0, result);
        System.out.println(sb);
    }

    // 순열...
    public static void permutation(int depth, char[] result) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = (char) (i + '0');
                permutation(depth + 1, result);
                visited[i] = false;
            }
        }
    }
}

// 내 풀이와 큰 차이 없음.. 배열로 띄어쓰기 구현한 정도?
// 상위 정답 - https://www.acmicpc.net/source/41491908
class BOJ15649Answer {
    static int N, M;
    static boolean[] check;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];
        answer = new char[2 * M];

        for (int i = 0; i < M - 1; i++)
            answer[2 * i + 1] = ' ';

        answer[2 * M - 1] = '\n';
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int m) {
        if (m == M) {
            sb.append(answer);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                check[i] = true;
                answer[2 * m] = (char) (i + '0');
                dfs(m + 1);
                check[i] = false;
            }
        }
    }
}