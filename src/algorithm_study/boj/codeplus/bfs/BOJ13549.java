package algorithm_study.boj.codeplus.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 숨바꼭질3 - https://www.acmicpc.net/problem/13549
public class BOJ13549 {
    public static void main(String[] args) throws IOException {
        // 수빈 점, n (0 ~ 100_000) 동생 점, k (0 ~ 100_000)
        // 걷거나 순간이동, X - 1, X + 1 : 1초
        // 순간이동 : 2 * x : 0초

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] dp = new int[100001];
//        Arrays.fill(dp, 100_001);
        Queue<Integer> que = new LinkedList<>();
        dp[n] = 1;
        que.add(n);

        while (!que.isEmpty()) {
            int now = que.poll();
            if (now == k) {
                break;
            }

            int temp = 0;
            for (int i = 0; i < 3; i++) {
                int index = dp[now] + 1;
                if (i == 0) {
                    temp = now * 2;
                    index--;
                } else if(i == 1) {
                    temp = now - 1;
                } else {
                    temp = now + 1;
                }

                if (temp < 0 || temp > 100000) {
                    continue;
                }
                if(dp[temp] != 0) {
                    continue;
                }
                que.add(temp);
                dp[temp] = index;

            }
        }
        System.out.println(dp[k] - 1);
    }
}