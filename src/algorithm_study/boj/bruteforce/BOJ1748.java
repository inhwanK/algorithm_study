package algorithm_study.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 이어 쓰기1 - https://www.acmicpc.net/problem/1748
public class BOJ1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int size = String.valueOf(n).length();

        int result = n * size;
        int temp = 9;
        int minus = 0;
        for (int i = 1; i < size; i++) {
            minus += temp;
            result -= minus;
            temp *= 10;
        }
        System.out.println(result);
    }
}

// 1위 정답 - https://www.acmicpc.net/source/16842573
class BOJ1748Answer {
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        int ans = 0;
        for (int start = 1, len = 1; start <= N; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end > N)
                end = N;
            ans += len * (end - start + 1);
        }
        System.out.println(ans);
    }

}