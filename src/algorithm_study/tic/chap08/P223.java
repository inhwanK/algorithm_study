package algorithm_study.tic.chap08;

import java.util.Scanner;

public class P223 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;

        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 3;
        } else if (n % 2 == 0) {
            result = (int) (Math.pow(3, n / 2) + Math.pow(3, (n / 2) - 1));
        } else {
            result = (int) Math.pow(3, (n - 1) / 2) * 2;
        }

        System.out.println(result % 796796);
    }
}
