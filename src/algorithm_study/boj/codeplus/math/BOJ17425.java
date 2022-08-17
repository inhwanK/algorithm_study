package algorithm_study.boj.codeplus.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 약수의 합 - https://www.acmicpc.net/problem/17425
public class BOJ17425 {
    public static long[] arr = new long[1000001];

    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 1000000; i++) {
            for (int j = 1; i * j <= 1000000; j++) {
                arr[i * j] += i;
            }
        }

        for (int i = 1; i <= 1000000; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append('\n');
        }
        System.out.println(sb);


        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime) / 1000;
        System.out.println("시간차이(m) : " + secDiffTime);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/43107542
class BOJ17425Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long dp[] = new long[1000001];
        dp[1] = 1;
        for (int i = 2; i <= 1000000; i++) {
            //백만이하의 수중 i의 배수들에게 해당 수를 더해준다.
            //2의 배수는 2, 4, 6, 8, 10 ... 따라서 해당 수들의 약수에 2가 포함된다.
            for (int j = 1; i*j <= 1000000; j++) {
                dp[i*j] += i;
            }
            dp[i] += (dp[i-1]+1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}