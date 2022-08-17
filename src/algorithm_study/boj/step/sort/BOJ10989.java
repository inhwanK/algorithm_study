package algorithm_study.boj.step.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기 3 - https://www.acmicpc.net/problem/10989
public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[] arr = new int[10001];
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(br.readLine());
            arr[index]++;
        }

        int count = 0;
        for (int i = 1; i < 10001; i++) {
            if (arr[i] > 0) {
                count++;
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i).append('\n');
                }
            }
            if(count == n) break;
        }
        System.out.println(sb);
    }
}