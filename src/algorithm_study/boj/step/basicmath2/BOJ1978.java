package algorithm_study.boj.step.basicmath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소수 찾기 - https://www.acmicpc.net/problem/1978
public class BOJ1978 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int prime = 0;
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            if (check(num)) prime++;
        }
        System.out.println(prime);
    }

    public static boolean check(int num) {
        int count = 0;
        for (int i = num; i > 0; i--) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count == 2) return true;
        else return false;
    }
}

// 1위 정답 - https://www.acmicpc.net/source/10081016
class BOJ1978Answer {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int len = 0;
        int count = 0;

        first:
        for (int i = 0; i < numbers.length; i++) {
            len = Integer.parseInt(numbers[i]);

            if (len == 1)
                continue;

            for (int j = 2; j <= len; j++)
                if (len % j == 0 && len != j)
                    continue first;

            count++;
        }
        System.out.println(count);
    }
}