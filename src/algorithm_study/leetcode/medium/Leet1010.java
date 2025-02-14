package algorithm_study.leetcode.medium;

// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/description/
public class Leet1010 {
    public int numPairsDivisibleBy60(int[] time) {
        // 요구사항
        // 개수 구하기
        // 어떤 개수? 두 요소를 더 했을 때, 60으로 나눠지는 경우의 수
        // 같은 인덱스는 절대 안됨, 즉 서로 다른 요소
        // 이 때 인덱스는 달라도 값은 같을 수 있겠네
        // time 배열의 길이는 60000 개가 최대
        // 요소는 1 ~ 500

        int result = 0;
        int[] count = new int[60];
        for (int i = 0; i < time.length; i++) {
            // 각 값들이 60으로 나눠지는지 미리 계산
            time[i] = time[i] % 60;
            // 배열로, 배열의 길이는 61
            count[time[i]]++;
        }

        for (int i = 1; i < 30; i++) {
            result += count[i] * count[60 - i];
        }

        // int 범위를 넘어서는 계산
        result += (long) count[0] * (long) (count[0] - 1) / 2;
        result += (long) count[30] * (long) (count[30] - 1) / 2;
        return result;
    }
}
