package algorithm_study.boj.step.step03;

// 1위 정답과 동일
// 정수 N개의 합 - https://www.acmicpc.net/problem/15596
public class BOJ15596 {
    long sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
