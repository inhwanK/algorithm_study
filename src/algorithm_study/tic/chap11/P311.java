package algorithm_study.tic.chap11;

import java.util.Arrays;
import java.util.Scanner;

// 모험가 길드 풀이 (정답)
public class P311 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()]++;
        }

        Arrays.sort(arr);

        int result = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += 1;
            if (count >= arr[i]) {
                result++;
                count = 0;
            }
        }

        System.out.println(result);

    }

}
