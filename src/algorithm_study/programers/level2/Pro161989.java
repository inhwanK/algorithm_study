package algorithm_study.programers.level2;

// 덧칠하기 - https://school.programmers.co.kr/learn/courses/30/lessons/161989
public class Pro161989 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end = 0;
        for (int i = 0; i < section.length; i++) {
            if (section[i] > end) {
                end = section[i] + m - 1;
                answer++;
            }
        }
        return answer;
    }
}
