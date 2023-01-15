package algorithm_study.boj.step.step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나머지 합 - https://www.acmicpc.net/problem/10986
public class BOJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] arrInput = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        arr[1] = Integer.parseInt(arrInput[0]);
        for (int i = 2; i <= n; i++) {
            arr[i] = Integer.parseInt(arrInput[i - 1]) + arr[i - 1];
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                if((arr[j + i - 1] - arr[j - 1]) % m == 0) {
                    count++;
                    System.out.println(j + i - 1);
                }
            }
        }
        System.out.println(count);
    }
}