package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 팩토리얼 - https://www.acmicpc.net/problem/10872
public class BOJ10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = factorial(n);
        System.out.println(result);
    }

    public static int factorial(int n) {
        if (n < 1) return 1;
        return n * factorial(n - 1);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/9517274
class BOJ10872Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int result = 1;
        while(n != 0) {
            result *= n;
            n--;
        }
        System.out.println(result);
    }
}