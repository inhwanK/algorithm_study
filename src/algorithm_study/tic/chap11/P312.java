package algorithm_study.tic.chap11;

import java.util.*;

// 곱하기 혹은 더하기
public class P312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        char[] chars = s.toCharArray();

        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int number = chars[i] - '0';

            sum = Math.max(sum + number, sum * number);

        }

        System.out.println(sum);
    }
}
