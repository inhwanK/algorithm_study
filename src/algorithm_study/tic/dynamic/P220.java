package algorithm_study.tic.dynamic;

import java.util.Scanner;

public class P220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] store = new int[101];
        // 3 <= n <= 100
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            store[i] = sc.nextInt();
        }

        int[] arr = new int[n];
        arr[0] = store[0];
        arr[1] = Math.max(store[0], store[1]);

        for (int i = 2; i < n; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + store[i]);
        }

        System.out.println(arr[n - 1]);
    }
}
