package algorithm_study.tic.dynamic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 효율적인 화폐 구성 풀이 : 구현 실패
public class P226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Integer[] money = new Integer[100];
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }

        Arrays.sort(money, Collections.reverseOrder());

    }
}
