package algorithm_study.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + num.charAt(i) - '0';
//            System.out.println(num.charAt(i) - '0');
        }
        System.out.println(sum);
    }
}

// 1위 정답
class BJ11720Answer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] numbers = br.readLine().toCharArray();
        int total = 0;

        for (int i = 0; i < N; i++) {
            total += Integer.parseInt(String.valueOf(numbers[i]));
        }
        System.out.println(total);
    }
}