package algorithm_study.boj.step.basicmath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 골드바흐의 추측 - https://www.acmicpc.net/problem/9020
public class BOJ9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[10001];
        check[0] = check[1] = true;

        for (int i = 2; i <= Math.sqrt(10000); i++) {
            for (int j = 2; i * j < 10001; j++) {
                if (!check[i * j]) check[i * j] = true;
            }
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            // 중간부터 내려오면서 소수 가져오기
            for (int temp = n / 2; temp > 0; temp--) {
                if (!check[temp] && !check[n - temp]) {
                    sb.append(temp + " " + (n - temp) + "\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

// 정답 코드와 큰 차이 없음.
// 상위 정답 - https://www.acmicpc.net/source/44217074
class BOJ9020Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        boolean[] prime = new boolean[10001];

        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length - 1); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            int mid = num / 2;
            while (true) {
                if (!prime[mid] && !prime[num - mid]) {
                    sb.append(mid).append(" ").append(num - mid).append("\n");
                    break;
                }
                mid--;
            }
        }
        System.out.println(sb);
    }
}
