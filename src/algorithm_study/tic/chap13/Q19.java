package algorithm_study.tic.chap13;

import java.util.*;

// 연산자 끼워 넣기
public class Q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();

        int max = -999999999;
        int min = 999999999;

        // 재귀를 써야하나요?
        // 첫 번째 방법, 그냥 반복문 존나 돌려서 최댓값, 최솟값 가져오기
        // 조합 알고리즘이 필요한 거 같음.
        // 생각해보니 조합 알고리즘이 재귀였던 것 같은데?

        // 조합 구현한번 해봅시다 자.
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        System.out.println(max);
        System.out.println(min);
    }

    public static void combi(int n, int c) {


        return;
    }
}
