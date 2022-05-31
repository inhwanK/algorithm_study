package algorithm_study.tic.chap11;

import java.util.Scanner;

public class Q03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int count0 = 0;
        int count1 = 0;

        if(s.charAt(0) == '0') count1++;
        else count0++;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i + 1) == '1') {
                    count0++;
                } else {
                    count1++;
                }
            }
        }

        int result = Math.min(count0, count1);
        System.out.println(result);
    }
}
