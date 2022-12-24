package algorithm_study.programers.level3;

// 기지국 설치 - https://school.programmers.co.kr/learn/courses/30/lessons/12979
public class Pro12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int range = 2 * w + 1;
        int start = 1;

        for (int i = 0; i < stations.length; i++) {
            int now = stations[i] - w - start;

            answer += now / range;
            if (now % range > 0) {
                answer++;
            }

            start = Math.min(stations[i] + w + 1, n + 1);
        }

        answer += (n + 1 - start) / range;
        if ((n + 1 - start) % range > 0) {
            answer++;
        }

        return answer;
    }
}
