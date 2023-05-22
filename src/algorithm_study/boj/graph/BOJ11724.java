package algorithm_study.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 연결 요소의 개수 - https://www.acmicpc.net/problem/11724
public class BOJ11724 {
    public static void main_1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        int[][] board = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            board[u][v] = 1;
            board[v][u] = 1;
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                continue;
            }

            que.add(i);
            visited[i] = true;

            while(!que.isEmpty()) {
                int target = que.poll();

                for(int j = 1; j <= n; j++) {
                    if(board[target][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        que.add(j);
                    }
                }
            }
            count++;
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        int[] parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);

            union(parent, u, v);
        }
        HashSet<Integer> set = new HashSet();
        for(int i = 1; i <= n; i++) {
            set.add(find(parent, i));
        }
        System.out.println(set.size());
    }
    static boolean union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if(a == b) return false;

        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
    static int find(int[] parent, int a) {
        if(parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent, parent[a]);
    }
}
