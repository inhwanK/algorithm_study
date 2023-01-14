package algorithm_study.boj.step.step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수열 - https://www.acmicpc.net/problem/2559
public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        String[] arrInput = br.readLine().split(" ");

        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += Integer.parseInt(arrInput[i]);
        }

        long max = sum;

        for (int i = k; i < n; i++) {
            sum -= Integer.parseInt(arrInput[i - k]);
            sum += Integer.parseInt(arrInput[i]);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}