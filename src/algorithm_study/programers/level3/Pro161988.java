package algorithm_study.programers.level3;

// 연속 펄스 부분 수열의 합 - https://school.programmers.co.kr/learn/courses/30/lessons/161988
public class Pro161988 {
    public long solution(int[] sequence) {
        long answer = 0;

        long cur1 = 0;
        long cur2 = 0;
        for (int i = 0; i < sequence.length; i++) {
            if(i % 2 == 0) {
                cur1 += sequence[i];
                cur2 += -sequence[i];
            } else {
                cur1 += -sequence[i];
                cur2 += sequence[i];
            }

            answer = Math.max(answer, cur1);
            answer = Math.max(answer, cur2);

            if(cur1 < 0) {
                cur1 = 0;
            }
            if(cur2 < 0) {
                cur2 = 0;
            }
        }
        return answer;
    }
}
