package algorithm_study.boj.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이전 순열 - https://www.acmicpc.net/problem/10973
public class BOJ10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 왼쪽부터 오른쪽으로 스캔
        // i-1번째 보다 작은 i번째 값들 중 최솟값 value 저장
        // 이 때 i-1 인덱스 저장
        int index = -1;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            System.out.println(-1);
            return;
        }

        for (int i = n - 1; i > index; i--) {


            if (arr[i] < arr[index]) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
//        int left = index + 1;
//        int right = n - 1;
//
//        while (left < right) {
//            int temp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = temp;
//
//            left++;
//            right--;
//        }
        for (int i = n - 1; i > index + 1; i--) {
            for (int j = 0; j < n - index - 2; j++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}