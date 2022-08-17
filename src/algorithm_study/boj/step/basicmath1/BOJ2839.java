package algorithm_study.boj.step.basicmath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 설탕 배달 - https://www.acmicpc.net/problem/2839
public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 4 || N == 7) {
            System.out.println(-1);
        } else if (N % 5 == 0) {
            System.out.println(N / 5);
        } else if (N % 5 == 1 || N % 5 == 3) {
            System.out.println((N / 5) + 1);
        } else if (N % 5 == 2 || N % 5 == 4) {
            System.out.println((N / 5) + 2);
        }
    }
}

// 1위 정답 - https://www.acmicpc.net/source/6451515
class BOJ2839Answer {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int num = 0;
        while (input % 5 != 0) {
            input -= 3;
            num++;
        }
        if (input < 0) System.out.println(-1);
        else {
            num += input / 5;
            System.out.println(num);
        }
        br.close();
    }
}