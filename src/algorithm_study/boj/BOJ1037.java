package algorithm_study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 약수 - https://www.acmicpc.net/problem/1037
public class BOJ1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ea = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = 1000001;
        int max = 0;
        for (int i = 0; i < ea; i++) {
            int temp = Integer.parseInt(st.nextToken());
            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }

        System.out.println(max * min);
    }
}