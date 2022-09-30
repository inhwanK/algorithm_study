package algorithm_study.programers.level1;

// 소수 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/12921
public class Pro12921 {
    public int solution(int n) {
        int answer = n - 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
}
