package algorithm_study.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 동전 0 - https://www.acmicpc.net/problem/11047
public class BOJ11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int index = n -1;
        int answer = 0;
        while(k != 0 && index != -1) {
            if(k % coin[index] != 0) {
                answer += k / coin[index];
                k = k % coin[index];
                index--;
                continue;
            }

            answer += k / coin[index];
            k = 0;
        }
        System.out.println(answer);
    }
}