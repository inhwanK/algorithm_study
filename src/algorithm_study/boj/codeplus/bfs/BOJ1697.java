package algorithm_study.boj.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 숨바꼭질 - https://www.acmicpc.net/problem/1697
public class BOJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        int[] dp = new int[100001];
        dp[n] = 1;

        Queue<Integer> que = new LinkedList();
        que.add(n);

        while (!que.isEmpty()) {
            int now = que.poll();
            if (now == k) {
                System.out.println(dp[now] - 1);
                break;
            }

            int index = dp[now] + 1;

            if (now + 1 <= 100000 && dp[now + 1] == 0) {
                dp[now + 1] = index;
                que.add(now + 1);
            }
            if (now - 1 > 0 && dp[now - 1] == 0) {
                dp[now - 1] = index;
                que.add(now - 1);
            }
            if (now * 2 <= 100000 && dp[now * 2] == 0) {
                dp[now * 2] = index;
                que.add(now * 2);
            }
        }
    }
}