package algorithm_study.tic.chap15;

import java.util.*;

// 정렬된 배열에서 특정 수의 개수 구하기 풀이 코드
// 순차 탐색을 쓰지 않고 구하기
public class P367 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(x, arr, 0, n - 1);

        if (result == -1) {
            System.out.println(result);
        } else {
            System.out.println(sequentialSearch(arr, x, result));
        }
    }

    static int sequentialSearch(int[] arr, int x, int target) {
        int count = 0;
        int increase = target;
        int decrease = target;
        // 처음 탐색한 요소 기준 인덱스를 감소시키면서 순차탐색
        while (arr[decrease] == x) {
            System.out.println(target + " 감소");
            count++;
            decrease--;
        }

        // 처음 탐색한 요소 기준 인덱스를 증가시키면서 순차탐색
        while (arr[increase + 1] == x) {
            System.out.println(target + " 증가");
            count++;
            increase++;

        }

        return count;
    }

    // 재귀로 구현한 이분탐색
    static int binarySearch(int x, int[] arr, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (x == arr[mid]) {
            return mid;
        } else if (arr[mid] < x) {
            return binarySearch(x, arr, mid + 1, end);
        } else {
            return binarySearch(x, arr, start, mid - 1);
        }
    }

}
