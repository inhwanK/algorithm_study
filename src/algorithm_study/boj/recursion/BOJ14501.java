package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 퇴사 - https://www.acmicpc.net/problem/14501
public class BOJ14501 {
    public static int n, max = 0;
    public static int[] time, price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new int[n + 1];
        price = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            price[i] = Integer.parseInt(input[1]);

            if (time[i] + i > n + 1) {
                price[i] = 0;
            }
        }

        calculateMaxPrice(1, 0);
        System.out.println(max);
    }

    public static void calculateMaxPrice(int day, int priceSum) {
        if (day >= n + 1) {
            max = Math.max(max, priceSum);
            return;
        }

        for (int i = day; i < n + 1; i++) {
            priceSum += price[i];
            calculateMaxPrice(i + time[i], priceSum);
            priceSum -= price[i];
        }
    }
}

// 상위 정답 - https://www.acmicpc.net/problem/14501
class BOJ14501Answer {

    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 1];
        int pay = 0;
        for (int i = 1; i <= N; i++) {
            String[] data = br.readLine().split(" ");
            T[i] = Integer.parseInt(data[0]);
            P[i] = Integer.parseInt(data[1]);
        }

        for (int i = 1; i <= N; i++) {
            if (i + T[i] <= N + 1) {
                dp[i] = P[i];
                int max = 0;
                for (int j = 1; j <= i; j++) {
                    if (j + T[j] <= i && dp[j] > max)
                        max = dp[j];
                }
                dp[i] += max;

                if (dp[i] > pay)
                    pay = dp[i];
            }
        }
        System.out.println(pay);
    }
}