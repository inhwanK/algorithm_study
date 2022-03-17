package algorithm_study.mogakco.prime;

import java.util.Scanner;

public class EratosEx {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean[] primeList = checkPrimeNumber(n);

        int count = countPrimeNumber(n, primeList);

        System.out.println(n + " 이하의 소수의 수 : " + count);

        int sum = 0;
        String sumList = "[";
        for (int i = 2; i < n; i++) {

            if (primeList[i]) {

                sumList += "" + i;
                sum += i;

                if (sum == n) {
                    sumList += "]";
                    System.out.println("연속된 소수 " + sumList + "의 합은 " + n + "입니다.");
                    break;
                }
                if (sum > n) {
                    System.out.println("연속된 소수의 합으로 " + n + "을 만들 수 없습니다.");
                    break;
                }

                sumList += ", ";
            }
        }
    }

    private static int countPrimeNumber(int n, boolean[] primeList) {
        int count = 0;
        for (int i = 2; i < n + 1; i++) {
            if (primeList[i]) {
                count++;
            }
        }
        return count;
    }

    public static boolean[] checkPrimeNumber(int n) {

        int range = n + 1;
        int sqrt = (int) Math.sqrt(range) + 1;

        boolean[] primeList = new boolean[range];
        for (int i = 0; i < range; i++) {
            primeList[i] = true;
        }

        for (int i = 2; i < sqrt; i++) {
            if (primeList[i]) {
                for (int j = i * i; j < n; j += i) {
                    primeList[j] = false;
                }
            }
        }

        return primeList;
    }
}
