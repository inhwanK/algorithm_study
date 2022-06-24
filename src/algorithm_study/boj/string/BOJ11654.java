package algorithm_study.boj.string;

import java.io.IOException;
import java.util.Scanner;

// 아스키 코드
public class BOJ11654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        int result = a.charAt(0);
        System.out.println(result);
    }
}

// 1위 정답
class BOJ11654Answer {
    public static void main(String[] args) throws IOException {
        int ch = System.in.read();
        System.out.println(ch);
    }
}
