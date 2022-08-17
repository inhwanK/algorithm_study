package algorithm_study.boj.codeplus.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 부분수열의 합 - https://www.acmicpc.net/problem/1182
public class BOJ1182 {
    static int n, s, part, count = 0, arr[], result[];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        String[] num = br.readLine().split(" ");
        visited = new boolean[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        for (int i = 1; i <= n; i++) {
            part = i;
            result = new int[i];
            subset(0, 0);
        }
        System.out.println(count);
    }

    static void subset(int depth, int start) {
        if (depth == part) {
            int sum = 0;
            for (int i = 0; i < part; i++) {
                sum += result[i];
            }
            if (sum == s) {
                count++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                subset(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

class BOJ1182_1 {
    static int n, s, count, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        String[] num = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }

        dfs(0, 0);
        // s가 0인 경우 스페셜 케이스,
        System.out.println(s == 0 ? count - 1 : count);
    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        dfs(depth + 1, arr[depth] + sum);
        dfs(depth + 1, sum);
    }
}