package algorithm_study.mogakco.prime;

import java.util.Scanner;
import java.util.Set;

public class EratosEx {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1;
        int range = n - 1;
        int sqrt = (int) Math.sqrt(n) + 1;
        int count = 0;

        boolean[] primeList = new boolean[n];
        for (int i = 0; i < n; i++) {
            primeList[i] = true;
        }

        for (int i = 2; i < sqrt; i++) {
            if (primeList[i]) {
                for (int j = i * i; j < n; j += i) {
                    primeList[j] = false;
                }
            }
        }
/*
        for (int i = 2; i < n; i++) {
            if (primeList[i]) {
                count++;
            }
        }
*/
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (primeList[i]) {

                sum += i;

                if (sum == range) {
                    System.out.println("연속된 소수로 " + range + "을 만들 수 있습니다.");
                    break;
                }
                if (sum > range) {
                    System.out.println("연속된 소수의 합으로 " + range + "을 만들 수 없습니다.");
                    break;
                }
            }
        }

//        System.out.println(count);

    }
}
