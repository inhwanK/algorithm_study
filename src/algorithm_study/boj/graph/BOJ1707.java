package algorithm_study.boj.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 이분 그래프 - https://www.acmicpc.net/problem/1707
public class BOJ1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        while(k-- > 0) {
            String[] testCase = br.readLine().split(" ");
            int V = Integer.parseInt(testCase[0]);
            int E = Integer.parseInt(testCase[1]);

            ArrayList<Integer>[] arr = (ArrayList[]) new ArrayList[V + 1];

            for(int i = 1; i <= V; i++) {
                arr[i] = new ArrayList();
            }

            for(int i = 0; i < E; i++) {
                String[] line = br.readLine().split(" ");
                int u = Integer.parseInt(line[0]);
                int v = Integer.parseInt(line[1]);

                arr[u].add(v);
                arr[v].add(u);
            }

            int[] color = new int[V + 1]; // 정점 방문 여부
            boolean flag = true;

            for(int i = 1; i <= V; i++) {
                if(color[i] == 0) {
                    dfs(arr, color, i, 1);
                }
            }

            for(int i = 1; i <= V; i++) {
                for(int j : arr[i]) {
                    if(color[i] == color[j]) {
                        flag = false;
                    }
                }
            }

            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static void dfs(ArrayList<Integer>[] arr, int[] color, int x, int c) {
        color[x] = c;
        for(int y : arr[x]) {
            if(color[y] == 0) {
                dfs(arr, color, y, 3 - c);
            }
        }
    }

}