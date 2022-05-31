package algorithm_study.tic.chap06;

import java.util.Arrays;
import java.util.Scanner;

public class P178 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            arr[i] = num;
        }

        Arrays.sort(arr);

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[N - 1 - i] = arr[i];
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
