package algorithm_study.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

// 4. 자동 줄바꿈 프로그램
public class LineBreaker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = input.length();

        char[] chArr = input.toCharArray();
        int len = 0;
        String result = "";
        for (int i = 0; i < n; i++) {
            if(len == 0 && chArr[i] == ' ') {
                continue;
            }

            if (len == 80) {
                System.out.println(result);
                len = 0;
                result = "";
                continue;
            }

            if (getHan(chArr[i]) && len >= 79) {
                System.out.println(result);
                len = 0;
                result = "";
            }

            if (getHan(chArr[i])) {
                len += 2;
            } else {
                len++;
            }

            result += chArr[i];
        }
        System.out.println(result);
    }

    private static boolean getHan(Character c) {
        return Pattern.matches("^[가-힣]", String.valueOf(c));
    }
}