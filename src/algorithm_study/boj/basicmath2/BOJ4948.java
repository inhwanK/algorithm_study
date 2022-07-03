package algorithm_study.boj.basicmath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 베르트랑 공준 - https://www.acmicpc.net/problem/4948
public class BOJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[246913];
        check[0] = check[1] = true;

        for (int i = 2; i <= Math.sqrt(246912); i++) {
            for (int j = 2; j * i < 246913; j++) {
                if (!check[i * j]) check[i * j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            int count = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (!check[i]) count++;
            }
            System.out.println(count);
            n = Integer.parseInt(br.readLine());
        }
    }
}

// 상위 정답  - https://www.acmicpc.net/source/12548383
class BOJ4948Answer_1 {
    static final int MAX = 123457 * 2;
    static boolean isPrime[] = new boolean[MAX];
    static int prime[] = new int[21790];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = setPrime();
        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                break;
            }
            int idx1 = binarySearch(input, size);
            int idx2 = binarySearch(input * 2, size);
            if (prime[idx2] == input * 2) {
                idx2++;
            } else if (prime[idx1] == input) {
                idx1++;
            }
            sb.append((idx2 - idx1));
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static int binarySearch(int num, int size) {
        int start = 1;
        int end = size - 1;
        while (start <= end) {
            int center = (start + end) / 2;
            if (prime[center] >= num) {
                end = center - 1;
            } else {
                start = center + 1;
            }
        }
        return start;
    }

    public static int setPrime() {
        int idx = 1;
        for (int i = 2; i < MAX; i++) {
            if (!isPrime[i]) {
                prime[idx++] = i;
                for (int j = i; j < MAX; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return idx;
    }
}

// 상위 정답 - https://www.acmicpc.net/source/10899494
class BOJ4948Answer_2 {
    public static int MAX = 246912; // 입력되는 수의 최대값이 12345 이니깐 2N 까지는 구해야 한다.

    public static boolean[] isNot_pNum;
    public static int[] pNumCntArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isNot_pNum = new boolean[MAX + 1];
        pNumCntArr = new int[MAX + 1];

        getPrimeNum();

        StringBuilder sb = new StringBuilder();

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            sb.append((pNumCntArr[num * 2] - pNumCntArr[num]) + "\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    public static void getPrimeNum() {
        // 소수 구하기
        isNot_pNum[1] = true;

        for (int i = 2; i <= MAX; i++) {
            for (int j = 2; i * j <= MAX; j++) {
                isNot_pNum[i * j] = true;
            }
        }
        // 0 ~ i 까지(최대:MAX) 까지의 수까지 존재하는 실수의 수를 구한다.
        for (int i = 2; i <= MAX; i++) {
            pNumCntArr[i] = pNumCntArr[i - 1];
            if (!isNot_pNum[i]) pNumCntArr[i]++;
        }
    }
}
