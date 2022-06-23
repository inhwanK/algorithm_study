package algorithm_study.tic.chap14;

import java.util.*;

// 너무 어렵게 생각함 참나 ㅎㅎㅎㅎ
// 안테나
public class Q24 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // 중간값(median)을 출력
        System.out.println(arr[(n - 1) / 2]);
    }
}