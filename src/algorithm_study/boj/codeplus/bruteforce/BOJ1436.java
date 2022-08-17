package algorithm_study.boj.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 영화감독 숌 - https://www.acmicpc.net/problem/1436
public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 실제 제목이 될 숫자 변수
        int titleNum = 665;
        while (n > 0) {
            titleNum++;
            if (String.valueOf(titleNum).contains("666")) n--;
        }
        System.out.println(titleNum);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/43950230
class BOJ1436Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cur = 0;
        int ans = 0;
        for (int prev = 0; ans == 0; prev++) {
            if (prev == 0) {
                cur++;
                if (cur == n)
                    ans = 666;
            } else if (prev % 1000 == 666) {
                for (int post = 0; post < 1000; post++) {
                    cur++;
                    if (cur == n)
                        ans = prev / 1000 * 1000000 + 666000 + post;
                }
            }
            // 10666, 11666, 12666, 13666, 14666, 15666, [16660, .., 16669], 17666, .., [26660, .., 26669], 27666, ..
            // [66600], [166600]..[566600], [766600]..[966600],
            else if (prev % 100 == 66) {
                for (int post = 0; post < 100; post++) {
                    cur++;
                    if (cur == n)
                        ans = prev / 100 * 100000 + 66600 + post;
                }
            }
            // 666, 1666, 2666, 3666, 4666, 5666, [6661, .., 6669], 7666, 8666, 9666
            // [6660], [16660]..[56660], [76660]..[96669], [106660]..[156660], [176660]..,
            else if (prev % 10 == 6) {
                for (int post = 0; post < 10; post++) {
                    cur++;
                    if (cur == n)
                        ans = prev / 10 * 10000 + 6660 + post;
                }
            } else if (prev % 10 != 6) {
                cur++;
                if (cur == n)
                    ans = prev * 1000 + 666;
            }
        }
        System.out.print(ans);
    }
}