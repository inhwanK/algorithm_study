package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 카드 구매하기 - https://www.acmicpc.net/problem/11052
public class BOJ11052 {
    static int n, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(input[i]);
        }

        for (int i = 2; i <= n; i++) {
            arr[i] = Math.max(arr[i], maxValue(i));
        }

        System.out.println(arr[n]);
    }

    public static int maxValue(int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (n - i < i) break;
            max = Math.max(max, arr[i] + arr[n - i]);
        }
        return max;
    }
}

// 1위 정답 - https://www.acmicpc.net/source/4487305
class BOJ11052Answer {

    private static int[] price;
    private static int[] maxPrice;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] priceStr = in.readLine().split(" ");
        price = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(priceStr[i - 1]);
        }
        maxPrice = new int[n + 1];
        getMax(n);
        System.out.println(maxPrice[n]);
    }

    private static void getMax(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (maxPrice[i] < maxPrice[i - j] + price[j]) {
                    maxPrice[i] = maxPrice[i - j] + price[j];
                }
            }
        }
    }
}