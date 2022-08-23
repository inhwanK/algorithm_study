package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2 x n 타일링 2 - https://www.acmicpc.net/problem/11727
public class BOJ11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                arr[i] = (arr[i - 1] * 2 + 1) % 10007;
            } else {
                arr[i] = (arr[i - 1] * 2 - 1) % 10007;
            }
        }
        System.out.println(arr[n]);
    }
}

// if문 없이 깔끔한 코드
// 상위 정답 - https://www.acmicpc.net/source/11923221
class BOJ11727Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        d[0] = 1;
        d[1] = 1;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 2 * d[i - 2];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
    }
}