package algorithm_study.boj.step.step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 인간-컴퓨터 상호작용 - https://www.acmicpc.net/problem/16139
public class BOJ16139 {
    public static void main(String[] args) throws IOException {
        // S, A, q, r, l
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] in = br.readLine().split(" ");
            char alpha = in[0].charAt(0);
            int l = Integer.parseInt(in[1]);
            int r = Integer.parseInt(in[2]);

            int count = 0;
            for (int j = l; j <= r; j++) {
                if (input[j] == alpha) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}