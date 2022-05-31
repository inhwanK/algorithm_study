package algorithm_study.tic.chap17;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 정확한 순위
public class Q38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], 0);
            arr[i][i] = i;

        }

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
//            heap.offer();
        }
    }
}