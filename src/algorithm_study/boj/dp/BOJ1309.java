package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 동물원 - https://www.acmicpc.net/problem/1309
public class BOJ1309 {
    static int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][3];
        arr[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i][0] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2]) % MOD;
            arr[i][1] = (arr[i - 1][0] + arr[i - 1][2]) % MOD;
            arr[i][2] = (arr[i - 1][0] + arr[i - 1][1]) % MOD;
        }

        System.out.println((arr[n][0] + arr[n][1] + arr[n][2]) % MOD);
    }
}

// 1위 정답 - https://www.acmicpc.net/source/11921429
class BOJ1309Answer_1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        System.out.println(f(a));
    }

    public static int f(int n) {
        int[] memo = new int[n + 3]; // 메모이제이션
        memo[1] = 3;
        memo[2] = 7;
        for (int i = 3; i <= n; i++) {
            memo[i] = (memo[i - 1] * 2 + memo[i - 2]) % 9901;
        }
        return memo[n];
    }
}

// 2위 정답 - https://www.acmicpc.net/source/22176466
class BOJ1309Answer_2 {
    // 1309
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 1; i < n; i++) {
            int a = arr[0] % 9901;
            int b = arr[1] % 9901;
            int c = arr[2] % 9901;
            int x = a + b + c;
            int y = x - b;
            arr[0] = x;
            arr[1] = arr[2] = y;
        }
        System.out.println((arr[0] + arr[1] + arr[2]) % 9901);
    }

}