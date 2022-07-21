package algorithm_study.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 리모컨 - https://www.acmicpc.net/problem/1107
public class BOJ1107 {
    public static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int in = Integer.parseInt(br.readLine());
        if (in != 0) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < in; i++) {
                int n = Integer.parseInt(input[i]);
                broken[n] = true;
            }
        }

        int count = 0;

        int min = 500001;

        int m = target;
        int p = target;
        // target에서 부터 수를 증가 및 감소시키기
        while (true) {
            // 100 이 될 경우 break;
            if (m == 100 || p == 100) {
                System.out.println(count);
                break;
            }

            int mTemp = -1;
            int pTemp = -1;
            if (isPossible(m)) {
                mTemp = (m + "").length();
                mTemp += count;
                mTemp = Math.min(Math.abs(m - 100) + count, mTemp);
//                System.out.println(mTemp);
//                break;
            }

            if (isPossible(p)) {
                pTemp = (p + "").length();
                pTemp += count;
                pTemp = Math.min(Math.abs(p - 100) + count, pTemp);
//                System.out.println(pTemp);
//                break;
            }
            int temp = Math.min(pTemp, mTemp);
            if (temp < min) {
                System.out.println(temp);
                break;
            }
            m--;
            p++;

            count++;
        }
    }

    public static boolean isPossible(int num) {
        if (num < 0) return false;

        String input = num + "";
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - '0';
            if (broken[index] == true) return false;
        }
        return true;
    }
}