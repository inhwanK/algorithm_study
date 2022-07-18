package algorithm_study.boj;

import java.util.*;
import java.io.*;

// 골드바흐의 추측 - https://www.acmicpc.net/problem/6588
public class BOJ6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = -1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append(n);
            for (int i = 1; i <= (n / 2); i += 2) {
                if (n % i == 0 && n % (n - i) == 0) {
                    sb.append(" = ").append(i).append(" + ").append(n - i).append('\n');
                    System.out.println(" > " + sb);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
