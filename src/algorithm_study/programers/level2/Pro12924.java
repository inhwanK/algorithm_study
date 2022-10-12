package algorithm_study.programers.level2;

// 숫자의 표현 - https://school.programmers.co.kr/learn/courses/30/lessons/12924
public class Pro12924 {
    public int solution(int n) {
        int answer = 1;
        int start = 0;
        while (start != n) {
            start++;
            int sum = 0;
            for (int i = start; i < n; i++) {
                sum += i;
                if (sum == n) {
                    answer++;
                    break;
                }
                if (sum > n) {
                    break;
                }
            }

        }
        return answer;
    }

    public int solution_answer(int num) {
        int answer = 0;
        for (int i = 1; i <= num; i += 2) {
            if (num % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}
