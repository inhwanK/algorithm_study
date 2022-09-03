package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알고리즘 수업 - 피보나치 수 1 -  https://www.acmicpc.net/problem/24416
public class BOJ24416 {
    static int recurCount, dpCount, f[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        f = new int[n + 1];
        fib(n);
        fibonacci(n);
        System.out.println(recurCount + " " + dpCount);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            recurCount++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    static int fibonacci(int n) {
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            dpCount++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}

// 상위 정답 - https://www.acmicpc.net/source/45950088
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fibo = new int[41];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i = 3; i <= 40; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        System.out.println(fibo[N] + " " + (N-2));
    }
}