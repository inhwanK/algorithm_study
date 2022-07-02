package algorithm_study.boj.basicmath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기 - https://www.acmicpc.net/problem/1929
public class BOJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        boolean[] prime = new boolean[1000001];
        prime[0] = prime[1] = true;

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) continue;
            int j = i + i;
            while (j <= n) {
                prime[j] = true;
                j += i;
            }
        }

        for (int i = m; i <= n; i++) {
            if (!prime[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}

// 문자열 나눌 때 split이 조금더 빠른듯?
// 상위 정답 - https://www.acmicpc.net/source/12599998
class BOJ1929Answer {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String nm[] = input.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        boolean prime[] = new boolean[m + 1];

        for (int i = 2; i <= m; i++) {
            if (prime[i]) continue;

            if (i >= n) sb.append(i + "\n");

            for (int j = i + i; j <= m; j += i) {
                prime[j] = true;
            }
        }

        System.out.println(sb);
    }
}