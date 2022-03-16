package algorithm_study.mogakco.prime;

import java.util.Scanner;

public class PrimeNumberEx {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for (int j = 0; j <= n; j++) {
            if (checkPrimeNumber(j)) {
                count++;
            }
        }

        System.out.println("소수의 개수 : " + count);
    }

    public static boolean checkPrimeNumber(int k) {
        if (k < 2) {
            return false;
        } else if (k == 2) {
            return true;
        }

        for (int i = 2; i < k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        System.out.println("소수 > " + k);
        return true;
    }
}
