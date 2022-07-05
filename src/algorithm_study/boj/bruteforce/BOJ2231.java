package algorithm_study.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String input = i + "";

            int temp = i;
            char[] arr = input.toCharArray();
            for (int j = 0; j < arr.length; j++) {
                temp += arr[j] - '0';
            }
            if (temp == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}

// toCharArray를 사용해 문자열을 배열로 바꿔서 계산함.
// 1위 정답 - https://www.acmicpc.net/source/30111738
class BOJ2231Answer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String autok = br.readLine();
        int c = Integer.valueOf(autok);

        int i = c - String.valueOf(c).length() * 9;
        int m = 0;

        while (true) {
            i++;

            char[] c_arr = String.valueOf(i).toCharArray();
            int sum = i;

            for (int ca = 0; ca < c_arr.length; ca++) {
                sum += (c_arr[ca] - 48);
            }
            m = sum;
            if (sum == c || i >= c) {
                break;
            }
        }

        if (m != c) i = 0;
        System.out.println(i);
    }
}