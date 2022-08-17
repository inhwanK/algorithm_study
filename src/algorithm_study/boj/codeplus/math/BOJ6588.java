package algorithm_study.boj.codeplus.math;

import java.io.*;

// 골드바흐의 추측 - https://www.acmicpc.net/problem/6588
public class BOJ6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = -1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append(n);
            for (int i = 3; i <= (n / 2); i += 2) {
                if (isPrime(i) && isPrime(n - i)) {
                    sb.append(" = ").append(i).append(" + ").append(n - i).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
// 이게 훨씬 빠름
class BOJ6588_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] primeArr = new boolean[1000001];
        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j * i <= 1000000; j++) {
                primeArr[i * j] = true;
            }
        }

        int n = -1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append(n);
            for (int i = 3; i <= (n / 2); i += 2) {
                if (!primeArr[i] && !primeArr[n - i]) {
                    sb.append(" = ").append(i).append(" + ").append(n - i).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/38721434
class BOJ6588Answer {
    static boolean[] sosu = new boolean[1000001];
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sosu[0] = sosu[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!sosu[i]) {
                for (int j = 2; j * i <= 1000000; j++) {
                    sosu[j * i] = true;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());

        while (n > 0) {
            goldbach(n);
            n = Integer.parseInt(br.readLine());
        }

        bw.flush();
        bw.close();
    }

    public static void goldbach(int num) throws IOException {
        for (int i = 3; i <= 1000000; i++) {
            if (!sosu[i] && i % 2 == 1) {
                if (!sosu[num - i] && (num - i) % 2 == 1) {
                    bw.write(num + " = " + i + " + " + (num - i) + "\n");
                    return;
                }
            }
        }
        bw.write("Goldbach's conjecture is wrong.\n");
    }
}