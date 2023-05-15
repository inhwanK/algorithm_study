package algorithm_study.programers.level2;

// 점 찍기 - https://school.programmers.co.kr/learn/courses/30/lessons/140107
public class Pro140107 {
    public long solution(int k, int d) {
        long answer = 0;
        for (long i = 0; i <= d; i += k) {
            long temp = i * i;
            long dd = (long) d * d;
            int top = (int) Math.sqrt(dd - temp);
            answer += (top / k) + 1;
        }
        return answer;
    }
}
