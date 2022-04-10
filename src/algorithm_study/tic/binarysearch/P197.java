package algorithm_study.tic.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class P197 {

    static String existParts = "";
    static int[] parts;
    static int[] searchParts;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        존재하는 배열 생성
        int N = sc.nextInt();
        parts = new int[N];

        for (int i = 0; i < N; i++) {
            parts[i] = sc.nextInt();
        }

        // 찾는 부품 배열 생성
        int M = sc.nextInt();
        searchParts = new int[M];

        for (int i = 0; i < M; i++) {
            searchParts[i] = sc.nextInt();
        }


//        parts 정렬.
        Arrays.sort(parts);

        // 시작점, 끝점 지정.
        int end = parts.length;
        int start = 0;

        for (int i = 0; i < searchParts.length; i++) {

            binarySearch(searchParts[i], start, end);
            existParts += " ";
        }

        System.out.println(existParts);
    }

    static void binarySearch(int target, int start, int end) {

        int mid = (start + end) / 2;

        if (start == mid) {
            existParts += "no";
            return;
        }

        if (parts[mid] == target) {
            existParts += "yes";
            return;
        } else if (parts[mid] < target) {
            binarySearch(target, mid + 1, end);
        } else if (parts[mid] > target) {
            binarySearch(target, start, mid - 1);
        }


    }

}
