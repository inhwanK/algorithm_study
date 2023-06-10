package algorithm_study.boj.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질 4 - https://www.acmicpc.net/problem/13913
public class BOJ13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] dp = new int[100001];
        int[] parent = new int[100001];

        Queue<Integer> que = new LinkedList<>();
        que.add(n);
        dp[n] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();
            int count = dp[now] + 1;

            if (now == k) {
                break;
            }

            if (now + 1 <= 100000 && dp[now + 1] == 0) {
                dp[now + 1] = count;
                que.add(now + 1);
                parent[now + 1] = now;
            }

            if (now * 2 <= 100000 && dp[now * 2] == 0) {
                dp[now * 2] = count;
                que.add(now * 2);
                parent[now * 2] = now;
            }

            if (now - 1 >= 0 && dp[now - 1] == 0) {
                dp[now - 1] = count;
                que.add(now - 1);
                parent[now - 1] = now;
            }
        }

        System.out.println(dp[k] - 1);

        Stack<Integer> stack = new Stack<>();
        int now = k;
        while (now != n) {
            stack.push(now);
            now = parent[now];
        }
        stack.push(n);

        while (!stack.isEmpty()) {
            int a = stack.pop();
            System.out.print(a + " ");
        }
    }
}