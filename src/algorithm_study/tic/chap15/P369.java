package algorithm_study.tic.chap15;

import java.util.Arrays;
import java.util.Scanner;

// 공유기 설치
public class P369 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0;
        int rigth = n - 1;
        int mid = n / 2;


        // 이분 탐색을 여러개 이상?
    }
}
