package algorithm_study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ4375 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int num = 0;
            for (int i = 1; ; i++) {
                num = (num * 10) + 1;
                num = num % n;
                if (num == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}

// 상위 정답 - https://www.acmicpc.net/source/36457225
class BOJ4375Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str.trim());

            int tmp = 1, count = 1;
            while (true) {
                if (tmp % n == 0) {
                    break;
                }
                tmp = (tmp * 10 + 1) % n;
                count++;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}