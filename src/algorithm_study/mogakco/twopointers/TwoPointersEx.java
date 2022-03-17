package algorithm_study.mogakco.twopointers;

import java.util.Scanner;

public class TwoPointersEx {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        // 입력
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        int count = 0;

        // 로직
        int start = 0; // 요소가 아니라 요소와 요소사이를 가리킴
        int end = 0; // 요소가 아니라 요소와 요소사이를 가리킴
        int sum = 0;

        while (start < N) {

            if (sum == M) {
                count++;
            }

            if (end >= N || sum > M) {
                sum -= arr[start++];
            } else {
                sum += arr[end++];
            }
        }

        System.out.println(count);

    }
}
