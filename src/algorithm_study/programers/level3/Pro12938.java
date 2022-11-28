package algorithm_study.programers.level3;

// 최고의 집합 - https://school.programmers.co.kr/learn/courses/30/lessons/12938
public class Pro12938 {
    public int[] solution(int n, int s) {

        int[] answer = new int[n];

        if (s < n) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        for (int i = n; i > 0; i--) {
            answer[n - i] = s / i;
            s -= answer[n - i];
        }

        return answer;
    }
}
