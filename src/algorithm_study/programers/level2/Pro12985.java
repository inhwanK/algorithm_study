package algorithm_study.programers.level2;

// 예상 대진표 - https://school.programmers.co.kr/learn/courses/30/lessons/12985
public class Pro12985 {
    public int solution(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        }

        return answer;
    }
}
