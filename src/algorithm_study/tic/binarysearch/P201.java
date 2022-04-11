package algorithm_study.tic.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P201 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int end = arr.length - 1;

//        계산된 값을 가지는 배열 추가로 생성
        int[] keyArr = new int[arr[end]];
        for (int i = 0; i < keyArr.length; i++) {

            keyArr[i] = calculator(arr, i);
            System.out.println(i + " : " + keyArr[i]);
        }

//        큰 수부터 차례로 탐색
        for (int i = keyArr.length - 1; i > 0; i--) {
            if(keyArr[i] == M){
//                조건에 맞으면 반복문 탈출
                System.out.println(i);
                break;
            }
        }
    }

    // 떡 자른 합 계산
    static int calculator(int[] arr, int key) {

        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - key > 0) {
                value += arr[i] - key;
            }
        }
        return value;
    }
}
