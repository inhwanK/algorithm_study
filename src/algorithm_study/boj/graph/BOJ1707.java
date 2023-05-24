package algorithm_study.boj.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 이분 그래프 - https://www.acmicpc.net/problem/1707
public class BOJ1707 {

    static int[][] board;
    static int V;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++) {
            String[] first = br.readLine().split(" ");
            V = Integer.parseInt(first[0]);
            int E = Integer.parseInt(first[1]);

            board = new int[V + 1][V + 1];

            for(int j = 0; j < E; j++) {
                String[] line = br.readLine().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);

                board[u][v] = 1;
                board[v][u] = 1;
            }
            flag = false;

            for(int ea = 1; ea <= V / 2 + 1; ea++) {
                int[] left = new int[ea];
//                int[] right = new int[V - ea];
                boolean[] visited = new boolean[V];
                dfs(0, ea, left, visited);
            }

            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int depth, int size, int[] left, boolean[] visited) {
        if(depth == size) {
            if(validCheck(left, visited)) {
                flag = true;
            }
            return;
        }

        for(int i = 1; i <= V; i++) {
            if(!visited[i - 1]) {
                left[depth] = i;
                visited[i - 1] = true;
                dfs(depth + 1, size, left, visited);
                visited[i - 1] = false;
            }
        }
    }

    private static boolean validCheck(int[] left, boolean[] visited) {
        ArrayList<Integer> leftList = new ArrayList();
        for(int i = 0; i < left.length; i++) {
            leftList.add(left[i]);
        }

        ArrayList<Integer> rightList = new ArrayList();
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                rightList.add(i + 1);
            }
        }

        for(int i = 0; i < leftList.size(); i++) {
            int target = leftList.get(i);
            for(int j = 1; j <= V; j++) {
                if(board[target][j] == 1 && leftList.contains(j)) {
                    return false;
                }
            }
        }

        for(int i = 0; i < rightList.size(); i++) {
            int target = rightList.get(i);
            for(int j = 1; j <= V; j++) {
                if(board[target][j] == 1 && rightList.contains(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}