package algorithm_study.tic.chap15;

import java.util.Scanner;

/*
입력
5
-15 -6 1 3 7

7
-15 -4 2 8 9 13 15

7
-15 -4 3 8 9 13 15
* */
// 고정점 찾기
public class P368 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int median = n / 2;
        int left = 0;
        int right = n - 1;

        int result = -1;
        while (left != right) {
            if (arr[median] == median){
                result = median;
                System.out.println("고정점 > " + result);
                break;
            }


            if (arr[median] < median) {
                left = median + 1;
                median = (left + right) / 2;
                System.out.println("되고 있나요?");
            } else {
                System.out.println("안되고 있나요?");
                right = median;
                median = (left + right) / 2;
            }
        }

        System.out.println("고정점이 없습니다. -1");
    }
}
