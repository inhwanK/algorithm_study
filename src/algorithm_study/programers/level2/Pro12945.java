package algorithm_study.programers.level2;

// 피보나치 수 - https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class Pro12945 {
    public int solution(int n) {
        int mod = 1234567;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % mod;
        }

        return arr[n];
    }
}
