package algorithm_study.tic.chap11;

import java.util.Arrays;
import java.util.Scanner;

public class Q04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < 2) {

            }
            if (arr[i + 1] - arr[i] < 1) {

            }
        }
    }
}
