package algorithm_study.programers.level2;

// 멀리 뛰기 - https://school.programmers.co.kr/learn/courses/30/lessons/12914
public class Pro12914 {
    public long solution(int n) {

        int[] arr = new int[2001];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        for (int i = 4; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }

        return arr[n];
    }
}
