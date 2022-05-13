package algorithm_study.tic.chap12;

import java.util.*;

/*
입력값
K1KA5CB7
AJKDLSI412K4JSJ9D
 */
// 문자열 재정렬
public class P322 {
    static String result = "";
    static String charString = "";
    static int numberSum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char[] charArr = s.toCharArray();


        for (int i = 0; i < charArr.length; i++) {
            int ascii = charArr[i] - '0';
            if (ascii < 10) {
                numberSum += ascii;
            } else {
                charString += charArr[i];
            }
        }

        char[] chars = charString.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length; i++) {
            result += chars[i];
        }

        if(numberSum > 0) result += numberSum + "";

        System.out.println(result);

    }
}
