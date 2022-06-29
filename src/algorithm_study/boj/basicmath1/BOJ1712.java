package algorithm_study.boj.basicmath1;

import java.util.*;
import java.io.*;

// 손익분기점 - https://www.acmicpc.net/problem/1712
public class BOJ1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int profit = c - b;
        if (profit <= 0) {
            System.out.println("-1");
            return;
        }
        System.out.println(a / profit + 1);
    }
}

// 1위 정답 - https://www.acmicpc.net/source/9408310
class BOJ1712Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int A, B, C;

        A = Integer.parseInt(tokenizer.nextToken());
        B = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        int profit = C - B;
        if (profit <= 0) {
            System.out.println("-1");
            return;
        }
        System.out.println(A / profit + 1);
    }
}
