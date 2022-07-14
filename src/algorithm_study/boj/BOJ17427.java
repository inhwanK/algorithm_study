package algorithm_study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 약수의 합 2 - https://www.acmicpc.net/problem/17427
public class BOJ17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int gn = 1;
        for (int x = 2; x <= n; x++) {
            int fx = divisorSum(x);
            gn += fx;
        }

        System.out.println(gn);
    }

    // 어떤 수의 약수의 합을 구한 값 즉 f(x)
    public static int divisorSum(int x) {
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                if (x / i == i) sum += i;
                else sum += i + (x / i);
            }

        }
        return sum;
    }
}
