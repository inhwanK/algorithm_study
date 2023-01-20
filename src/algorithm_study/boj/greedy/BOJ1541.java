package algorithm_study.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 잃어버린 괄호 - https://www.acmicpc.net/problem/1541
public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("-");

        int answer = 0;
        for (int i = input.length - 1; i >= 1; i--) {
            answer += calc(0, input[i]);
        }
        answer -= calc(0, input[0]);
        System.out.println(-answer);
    }

    private static int calc(int sum, String input) {
        String[] sp = input.split("\\+");
        for (int j = 0; j < sp.length; j++) {
            sum += Integer.parseInt(sp[j]);
        }
        return sum;
    }
}