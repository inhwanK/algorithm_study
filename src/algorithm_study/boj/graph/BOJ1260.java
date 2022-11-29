package algorithm_study.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// DFS와 BFS - https://www.acmicpc.net/problem/1260
public class BOJ1260 {
    static int n, m, v, board[][];
    static String dfsResult, bfsResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        v = Integer.parseInt(input[2]);


        board = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            board[x][y] = 1;
            board[y][x] = 1;
        }

        boolean[] visited = new boolean[n + 1];

        // dfs
        dfsResult = String.valueOf(v);
        visited[v] = true;
        dfs(1, v, visited);

        // visisted 초기화
        for (int i = 0; i < n + 1; i++) {
            visited[i] = false;
        }

        // bfs
        Queue<Integer> que = new LinkedList<>();
        visited[v] = true;
        que.offer(v);
        bfsResult = String.valueOf(v);

        while (!que.isEmpty()) {
            Integer now = que.poll();
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && board[now][i] == 1) {
                    visited[i] = true;
                    que.offer(i);
                    bfsResult += " " + i;
                }
            }
        }


        System.out.println(dfsResult);
        System.out.println(bfsResult);
    }

    public static void dfs(int depth, int start, boolean[] visited) {
        if (depth == n) {
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i] && board[start][i] == 1) {
                visited[i] = true;
                dfsResult += " " + i;
                dfs(depth + 1, i, visited);
            }
        }
    }
}