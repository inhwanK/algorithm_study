package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 피보나치 수 5 - https://www.acmicpc.net/problem/10870
public class BOJ10870 {
    static int[] fibo = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(fibo, -1);
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;
        System.out.println(getFibo(n));
    }

    public static int getFibo(int n) {
        int pre = 0;
        int ppre = 0;
        if(n <= 2) {
            return fibo[n];
        } else {
            if (fibo[n - 2] != -1) ppre = fibo[n - 2];
            else {
                ppre = getFibo(n - 2);
                fibo[n - 2] = ppre;
            }

            if (fibo[n - 1] != -1) pre = fibo[n - 1];
            else {
                pre = getFibo(n - 1);
                fibo[n - 1] = pre;
            }
            fibo[n] = pre + ppre;
        }
        return fibo[n];
    }
}
// 이거 메모이제이션 따위 필요없군요?? 범위가 작으니까 금방되나봐여
// 상위 정답 - https://www.acmicpc.net/source/16491351
class BOJ10870Answer {
    public static int N;
    public static int solve(int i) {
        if(i == 0)
            return 0;
        if(i == 1)
            return 1;

        return solve(i-2) + solve(i-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(solve(N));
    }
}