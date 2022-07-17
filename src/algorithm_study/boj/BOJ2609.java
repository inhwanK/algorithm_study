package algorithm_study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 풀이 과정 블로그 - https://st-lab.tistory.com/154
// 최대공약수와 최소공배수 - https://www.acmicpc.net/problem/2609
public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        int divisor = 0;
        int multiple = 0;
        for (int i = (int) Math.sqrt(max); i >= 1; i--) {
            if (max % i == 0) {
                if (min % i == 0)
                    divisor = Math.max(divisor, i);

                if (min % (max / i) == 0)
                    divisor = Math.max(divisor, (max / i));
            }
        }
        System.out.println(divisor);

        for (int i = 1; i <= max; i++) {
            multiple = (min * i);
            if (multiple % max == 0) {
                System.out.println(multiple);
                break;
            }
        }
    }
}

// 재귀
// 상위 정답 - https://www.acmicpc.net/source/7725844
class BOJ2609Answer_1 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(a, b);

        System.out.println(gcd);
        System.out.println(a * b / gcd);
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}

// 반복문
// 상위 정답 - https://www.acmicpc.net/source/36265943
class BOJ2609Answer_2 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int G = gcd(A, B);

        System.out.println(G); // 최대 공약수

        System.out.println(A * B / G); // 최소 공배수
    }
}