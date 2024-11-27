package algorithm_study.programers.level1;

// [PCCE 기출문제] 9번 / 지폐접기 - https://school.programmers.co.kr/learn/courses/30/lessons/340199
public class Pro340199 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (!((bill[0] <= wallet[0] && bill[1] <= wallet[1]) ||
                (bill[0] <= wallet[1] && bill[1] <= wallet[0]))) {

            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }

        return answer;
    }
}


