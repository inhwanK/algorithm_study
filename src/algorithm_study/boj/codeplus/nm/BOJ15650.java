package algorithm_study.boj.codeplus.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 순열과 다른 점은 반복문 시작점을 증가시킨다는 것
// N과 M (2) - https://www.acmicpc.net/problem/15650
public class BOJ15650 {
    public static int n, m;
    public static char[] result;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        result = new char[m * 2];
        Arrays.fill(result, ' ');

        combination(1, 0);
        System.out.print(sb);
    }

    public static void combination(int start, int depth) {
        if (depth == m) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            result[depth * 2] = (char) (i + '0');
            combination(i + 1, depth + 1);
        }
    }
}

// 내 풀이와 거의 동일함.
// 상위 정답 - https://www.acmicpc.net/source/15020387
class BOJ15650Answer_1 {
    static int N, M, nums[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        combi(0, 0);
        System.out.println(sb);
    }

    private static void combi(int before, int index) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = before + 1; i <= N; i++) {
            nums[index] = i;
            combi(i, index + 1);
        }
    }
}

// 내 풀이와 다른 방식, visited 배열로 체크하면서 증가,
// 상위 정답 - https://www.acmicpc.net/source/13502821
class Main {
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visit;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new int[m];
        visit = new boolean[n];

        dfs(0, 0);
        System.out.println(sb);

    }

    public static void dfs(int v, int cnt) {

        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");

            return;
        }
        for (int i = v; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[cnt] = i + 1;
                dfs(i, cnt + 1);
                visit[i] = false;
            }
        }
    }

}