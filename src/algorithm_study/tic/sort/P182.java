package algorithm_study.tic.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] a = new int[N];
        int[] b = new int[N];

        arraySort(N, a, sc);
        arraySort(N, b, sc);

        // swap

        int swap = 0;
        for (int i = 0; i < N; i++) {

            if (a[i] < b[N - 1 - i]) {
                int temp = a[i];
                a[i] = b[N - 1 - i];
                b[N - 1 - i] = temp;
                swap++;
            } else {
                break;
            }

            if (K == swap) {
                break;
            }
        }

        // 배열의 합 구하기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += a[i];
        }

        System.out.printf("%d", sum);
    }

    // 배열 입력 받은 뒤, 오름차순 정렬
    private static void arraySort(int N, int[] arr, Scanner sc) {
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
    }
}
