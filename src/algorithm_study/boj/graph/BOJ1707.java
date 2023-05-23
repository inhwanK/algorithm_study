package algorithm_study.boj.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 이분 그래프 - https://www.acmicpc.net/problem/1707
public class BOJ1707 {
    static int V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            String[] first = br.readLine().split(" ");
            V = Integer.parseInt(first[0]);
            int E = Integer.parseInt(first[1]);

            int[][] board = new int[V + 1][V + 1];

            for(int j = 0; j < E; j++) {
                String[] line = br.readLine().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);

                board[u][v] = 1;
                board[v][u] = 1;
            }

            int[] arr = new int[1];
            boolean[] visited = new boolean[V];

        }
    }

    private static void dfs(int size, int depth, int V, ArrayList<Integer> list, boolean[] visited) {
        if(size == depth) {
            return;
        }

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                list.add(i + 1);
                dfs(size + 1, depth, V, list, visited);
            }


        }

    }
}
