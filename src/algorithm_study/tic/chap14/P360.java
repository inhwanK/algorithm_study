package algorithm_study.tic.chap14;

import java.util.*;

// 너무 어렵게 생각함 참나 ㅎㅎㅎㅎ
// 안테나
public class P360 {

    public static int n;
    public static int[] house = new int[100000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int result = 999999999;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            house[arr[i]]++;
        }

        for (int i = 0; i < n; i++) {
            result = Math.min(result, sum(arr[i]));
        }
        // 계수정렬을 한다고 치고,

        System.out.println("결과 > " + result);
    }

    public static int sum(int antena) {
        int sum = 0;

        for (int i = 0; i < house.length; i++) {
            sum += Math.abs(house[i] * (i - antena));
        }

        return sum;
    }
}