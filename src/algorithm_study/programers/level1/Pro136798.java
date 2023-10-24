package algorithm_study.programers.level1;

// 기사단원의 무기 - https://school.programmers.co.kr/learn/courses/30/lessons/136798
public class Pro136798 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        // 자기 번호의 '약수 개수'에 해당하는 공격력을 가진 무기 구매함.
        // 아무튼 약수 개수를 구하고,
        // 약수 개수가 limit을 넘는지 판별하여
        // 넘는경우와 넘지 않는 경우에 대한 계산을 하면됨

        for (int i = 2; i <= number; i++) {
            int count = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (i / j == j) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }

            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }

        return answer + 1;
    }

    public int solutionAnswer(int number, int limit, int power) {
        int[] count = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) { //
                count[i * j]++;
            }
        }
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (count[i] > limit) {
                answer += power;
            } else {
                answer += count[i];
            }
        }
        return answer;
    }
}
