package algorithm_study.boj.bruteforce.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (3) - https://www.acmicpc.net/problem/15651
public class BOJ15651 {
    public static int n, m;
    public static StringBuilder sb;
    public static char[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        sb = new StringBuilder();

        result = new char[m];
        dupPermutation(0);
        System.out.println(sb);
    }

    public static void dupPermutation(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            result[depth] = (char) (i + '0');
            dupPermutation(depth + 1);
        }
    }
}

// 풀이 거의 동일함
// 상위 정답 - https://www.acmicpc.net/source/41565788
class BOJ15651Answer {
    static int N, M;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new char[2 * M];

        for (int i = 0; i < M - 1; i++)
            answer[2 * i + 1] = ' ';
        answer[2 * M - 1] = '\n';
        solution(0);
        System.out.println(sb);
    }

    public static void solution(int idx) {
        if (idx == M) {
            sb.append(answer);
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            answer[idx * 2] = (char) (i + '0');
            solution(idx + 1);
        }
    }
}