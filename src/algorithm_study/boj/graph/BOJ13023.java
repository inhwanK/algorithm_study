package algorithm_study.boj.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// ABCDE - https://www.acmicpc.net/problem/13023
public class BOJ13023 {
    static int n, m, answer;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[m];
        arr = new int[m][2];

        for (int i = 0; i < m; i++) {
            String[] rel = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(rel[0]);
            arr[i][1] = Integer.parseInt(rel[1]);
        }

        for (int i = 0; i < m; i++) {
            visited[i] = true;
            dfs(0, arr[i][1]);
            visited[i] = false;
        }

        System.out.println(answer);

    }

    public static void dfs(int depth, int target) {
        if (depth == 5) {
            answer = 1;
            return;
        }

        for (int i = 0; i < m; i++) {
            if (!visited[i] && target == arr[i][0]) {
                visited[i] = true;
                dfs(depth + 1, arr[i][1]);
                visited[i] = false;
            }
        }
    }
}


class BOJ13023Answer {
    private static int m;
    private static ArrayList<Integer>[] list;
    private static int ans = 0;
    private static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        m = M;

        //DFS를 위한 인접리스트 구현하기
        list = new ArrayList[N];
        v = new boolean[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        //N-1까지의 모든 정점에서 DFS를 통해 확인
        for (int i = 0; i < N; i++) {
            if (ans == 0)
                dfs(i, 1);
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int depth) {
        //System.out.println(start + " " + depth); //방문 정점과 깊이를 확인해보고 싶을 때 사용
        if (depth == 5) {
            ans = 1;
            return;
        }

        v[start] = true;
        for (int i : list[start]) {
            int next = i;
            if (!v[next]) {
                dfs(next, depth + 1);
            }
        }
        v[start] = false;

    }
}