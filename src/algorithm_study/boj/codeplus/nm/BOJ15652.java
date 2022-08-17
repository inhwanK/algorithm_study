package algorithm_study.boj.codeplus.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (4) - https://www.acmicpc.net/problem/15652
public class BOJ15652 {
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
        permutation(0, 1);
        System.out.println(sb);
    }

    public static void permutation(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            result[depth] = (char) (i + '0');
            permutation(depth + 1, i);
        }
    }
}

// 반복문 M까지만 도는 거였구나.. ㅎ
// 상위 정답 - https://www.acmicpc.net/source/42391691
class BOJ15652Answer {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static char[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = new char[2*M];
        for (int i = 0; i<M; i++) {
            answer[i*2+1] = ' ';
        }
        answer[2*M-1] = '\n';
        dfs(0, 0);
        System.out.print(sb);
    }

    public static void dfs(int cnt, int min) {
        if (cnt == M) {
            sb.append(answer);
            return;
        }
        for (int i = min; i<N; i++) {
            answer[cnt*2] = (char)(i+1+'0');
            dfs(cnt+1, i);
        }
    }
}